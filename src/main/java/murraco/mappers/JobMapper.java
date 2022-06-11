package murraco.mappers;

import murraco.dto.v1.JobDTO;
import murraco.enums.JobType;
import murraco.helpers.EnumHelper;
import murraco.model.Job;

public class JobMapper {
    public static Job toEntity(JobDTO jobDTO) {
        Job job = new Job();
        job.setId(jobDTO.getId());
        job.setTitle(jobDTO.getTitle());
        job.setDescription(job.getDescription());
        job.setSalary(jobDTO.getSalary());
        JobType jobType = EnumHelper.getJobTypeFromIndex(jobDTO.getJobType());
        job.setJobType(jobType);
        job.setProvinces(jobDTO.getProvinces());
        job.setRequirements(job.getRequirements());
        return job;
    }

    public static JobDTO toDTO(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setSalary(job.getSalary());
        jobDTO.setJobType(job.getJobType().getIndex());
        jobDTO.setProvinces(job.getProvinces());
        jobDTO.setRequirements(job.getRequirements());
        jobDTO.setCreatedDate(job.getCreatedDate().toString());
        jobDTO.setModifiedDate(job.getModifiedDate().toString());
        return jobDTO;
    }
}
