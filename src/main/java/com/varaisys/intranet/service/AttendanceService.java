package com.varaisys.intranet.service;

import java.util.List;

import com.varaisys.intranet.model.AttendanceDataModel;
import com.varaisys.intranet.utils.AttendanceData;


/**
 * 
 * @author Babli Singh
 * @Created on 16/feb/2023
 * @Created on 16-feb-2023
 */
public interface AttendanceService {
	
	public List<AttendanceDataModel> getAttendanceData();
	public boolean addAttendance(AttendanceData attendanceData);

}
