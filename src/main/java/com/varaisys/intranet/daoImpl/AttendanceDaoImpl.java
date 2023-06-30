package com.varaisys.intranet.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.AttendanceDao;
import com.varaisys.intranet.model.AttendanceDataModel;

/**
 * 
 * @author Babli Singh
 * @Created on 16/feb/2023
 * @Created on 16-feb-2023
 */

@Repository
public class AttendanceDaoImpl extends AbstractDao<Integer , AttendanceDataModel> implements AttendanceDao {

	@Override
	public void saveAttendance(AttendanceDataModel attendanceDataModel) {
		persist(attendanceDataModel);
		
	}

	@Override
	public List<AttendanceDataModel> getAllData() {
		return createEntityCriteria().list();
	}
	

}
