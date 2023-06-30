package com.varaisys.intranet.dao;

import java.util.List;
import com.varaisys.intranet.model.JobsTitles;

/**
 * 
 * @author Sachin Kashyap
 * @ created on 11-nov-2022
 * @modify on 14-nov-2022
 */
public interface JobTitlesDao {
	public void saveJobTitles(JobsTitles jobsTitles);

	public List<JobsTitles> getAllTitles();

	public JobsTitles getTitlesById(Long id);

	public JobsTitles getTitlesByJobTitles(String jobTitles);

}
