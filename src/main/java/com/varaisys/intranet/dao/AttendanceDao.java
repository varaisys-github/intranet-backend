package com.varaisys.intranet.dao;

import java.util.List;

import com.varaisys.intranet.model.AttendanceDataModel;



/**
 * 
 * @author Babli Singh
 * @Created on 16/feb/2023
 * @Created on 16-feb-2023
 */
public interface AttendanceDao {

	
	public  void saveAttendance(AttendanceDataModel attendanceDataModel);

	public List<AttendanceDataModel> getAllData();
}
