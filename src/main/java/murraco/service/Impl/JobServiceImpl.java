package murraco.service.Impl;

import lombok.RequiredArgsConstructor;
import murraco.dto.v1.EmployeeDTO;
import murraco.dto.v1.JobDTO;
import murraco.dto.v1.paging.JobPaging;
import murraco.mappers.EmployeeMapper;
import murraco.mappers.JobMapper;
import murraco.model.Employee;
import murraco.model.Job;
import murraco.repository.EmployeeRepository;
import murraco.repository.JobRepository;
import murraco.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public JobPaging getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Job> jobPage = jobRepository.findAll(paging);
        List<JobDTO> jobDTOList = new ArrayList<>();
        for (Job job : jobPage) {
            Employee employee = employeeRepository.findById(job.getCreatedBy()).orElseGet(Employee::new);
            EmployeeDTO employeeDTO = EmployeeMapper.toDTO(employee);
            JobDTO jobDTO = JobMapper.toDTO(job);
            jobDTO.setEmployeeDTO(employeeDTO);
            jobDTOList.add(jobDTO);
        }

        JobPaging jobPaging = new JobPaging();
        jobPaging.setJobDTOList(jobDTOList);
        jobPaging.setPageNo(pageNo);
        jobPaging.setTotalPage(jobPage.getTotalPages());
        return jobPaging;
    }

    @Override
    public Integer save(JobDTO jobDTO) {
        Job job = JobMapper.toEntity(jobDTO);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Integer employeeId = employeeRepository.findEmployeeIdByUsername(username);
        job.setCreatedBy(employeeId);
        jobRepository.save(job);
        return job.getId();
    }
}
