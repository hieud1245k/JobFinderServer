package murraco.dto.v1.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import murraco.dto.v1.JobDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPaging {
    private List<JobDTO> jobDTOList;
    private Integer pageNo;
    private Integer totalPage;
}
