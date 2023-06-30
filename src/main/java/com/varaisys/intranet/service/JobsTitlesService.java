package com.varaisys.intranet.service;

import java.util.List;
import com.varaisys.intranet.model.JobsTitles;
import com.varaisys.intranet.utils.JobsTitlesForm;
public interface JobsTitlesService {
public void saveJobsTitles(JobsTitlesForm jobsTitlesForm );
public List<JobsTitles>getAllJobTitles();
}
