package com.varaisys.intranet.model;
import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Sachin Kashyap
 *@created 11-nov-2022
 *@Created on 14-nov-2022
 */
@Entity
@Table(name="jobs_titles")
public class JobsTitles implements Serializable{
	public JobsTitles(){	
	}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;
@Column(name="job_titles")
private String  jobTitle;
@Column(name="job_description")
private String jobDescription;
@Column(name="created_date")
private LocalTime createdDate;
@Column(name="modify_date")
private LocalTime modifyDate;
@Column(name="status")
private String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Column(name="note")
private String  note;
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
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
	this.jobTitle = jobTitle;
}
public String getJobDescription() {
	return jobDescription;
}
public void setJobDescription(String jobDescription) {
	this.jobDescription = jobDescription;
}
public LocalTime getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalTime createdDate) {
	this.createdDate = createdDate;
}
public LocalTime getModifyDate() {
	return modifyDate;
}
public void setModifyDate(LocalTime modifyDate) {
	this.modifyDate = modifyDate;
}
}
