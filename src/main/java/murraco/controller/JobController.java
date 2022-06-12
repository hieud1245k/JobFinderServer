package murraco.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import murraco.dto.v1.JobDTO;
import murraco.dto.v1.paging.JobPaging;
import murraco.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@Api(tags = "jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_APPLICANT')")
    public ResponseEntity<JobPaging> getJobList(@RequestParam(defaultValue = "0") Integer pageNo,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(jobService.getAll(pageNo, pageSize, sortBy));
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<Integer> saveJob(@RequestBody JobDTO jobDTO) {
        return ResponseEntity.ok(jobService.save(jobDTO));
    }
}
