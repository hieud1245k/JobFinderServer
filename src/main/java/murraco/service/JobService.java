package murraco.service;

import murraco.dto.v1.JobDTO;
import murraco.dto.v1.paging.JobPaging;

import java.util.List;

public interface JobService {
    JobPaging getAll(Integer pageNo, Integer pageSize, String sortBy);
    Integer save(JobDTO jobDTO);
}
