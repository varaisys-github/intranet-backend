package com.varaisys.intranet.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.AttendanceDao;
import com.varaisys.intranet.model.AttendanceDataModel;
import com.varaisys.intranet.service.AttendanceService;
import com.varaisys.intranet.utils.AttendanceData;

/**
 * 
 * @author Babli Singh
 * @Created on 16/feb/2023
 * @Created on 16-feb-2023
 */
@Service()
@Transactional()
public class AttendanceServiceImpl implements AttendanceService{
	private boolean flag = false;
	@Autowired
	AttendanceDao attendanceDao;
	
	
	
	@Override
	public boolean addAttendance(AttendanceData attendanceData) {
		
		
		AttendanceDataModel attendanceDataModel = new AttendanceDataModel();
//		attendanceDataModel.setId(attendanceData.getId());
		attendanceDataModel.setInDate(attendanceData.getInDate());
		attendanceDataModel.setInIp(attendanceData.getInIp());
		attendanceDataModel.setInTime(attendanceData.getInTime());
		attendanceDataModel.setOutDate(attendanceData.getOutDate());
		attendanceDataModel.setOutIp(attendanceData.getOutIp());
		attendanceDataModel.setOutTime(attendanceData.getOutTime());
		attendanceDataModel.setDuration(attendanceData.getDuration());
		attendanceDao.saveAttendance(attendanceDataModel);
		System.out.println("attendance service impl");
		return flag;
		
	}

	
	
	@Override
	public List<AttendanceDataModel> getAttendanceData() {
		return attendanceDao.getAllData();
	}

}
