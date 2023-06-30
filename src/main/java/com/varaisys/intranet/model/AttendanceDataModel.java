package com.varaisys.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Babli singh
 *@created 16-feb-2023
 *@Created on 16-feb-2023
 */


@Entity
@Table(name="attendance_table")
public class AttendanceDataModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="inDate")
	private String inDate;
	@Column(name="inTime")
	private String inTime;
	@Column(name="inIp")
	private String inIp;
	@Column(name="outDate")
	private String outDate;
	@Column(name="outTime")
	private String outTime;
	@Column(name="outIp")
	private String outIp;
	@Column(name="duration")
	private String duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getInIp() {
		return inIp;
	}
	public void setInIp(String inIp) {
		this.inIp = inIp;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getOutIp() {
		return outIp;
	}
	public void setOutIp(String outIp) {
		this.outIp = outIp;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public AttendanceDataModel(int id, String inDate, String inTime, String inIp, String outDate, String outTime,
			String outIp, String duration) {
		super();
		this.id = id;
		this.inDate = inDate;
		this.inTime = inTime;
		this.inIp = inIp;
		this.outDate = outDate;
		this.outTime = outTime;
		this.outIp = outIp;
		this.duration = duration;
	}
	public AttendanceDataModel() {
		super();
	}
	
	
	
	
	
	

}
