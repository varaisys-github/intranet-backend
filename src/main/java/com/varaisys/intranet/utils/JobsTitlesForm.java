package com.varaisys.intranet.utils;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 
 * @author Sachin kashyap
 * @created on 11-nov-20222
 *@Modify on 14-nov-2022
 */
public class JobsTitlesForm {
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle= jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
private Long id;
private String  jobTitle;
private String jobDescription;
private String note;
private String status;
private MultipartFile file;
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
