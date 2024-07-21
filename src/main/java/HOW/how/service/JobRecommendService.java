package HOW.how.service;

import HOW.how.domain.JobRecommend;
import HOW.how.dto.JobRecommendDTO;



public interface JobRecommendService {
    JobRecommend saveJobRecommend();
    JobRecommend recommendJobs(boolean isUpdate);
    JobRecommendDTO getJobRecommends();
}
