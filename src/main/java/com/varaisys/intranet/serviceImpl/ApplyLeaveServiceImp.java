package com.varaisys.intranet.serviceImpl;

import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.varaisys.intranet.dao.ApplyLeaveDao;
import com.varaisys.intranet.dao.EntitlementDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserDetail;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.ApplyLeaveService;
import com.varaisys.intranet.service.EntitlementServices;
import com.varaisys.intranet.utils.ApplyLeaveForm;

@Service()
@Transactional("mydb")
public class ApplyLeaveServiceImp implements ApplyLeaveService {
	
	@Autowired
	ApplyLeaveDao applyLeaveDao;
	@Autowired
	UserServiceImpl userServicesImp;
	@Autowired
	EntitlementServices entitlementServiceImp;

	private boolean checkSaveLeaveApply = false;

	@Override
	public boolean saveApplyLeave(String id, ApplyLeaveForm applyLeaveForm) {
		ApplyLeave applyLeave = new ApplyLeave();

		applyLeave.setEmployeeId(id);
		applyLeave.setEmployeeName(getName(id));
		applyLeave.setLeaveType(applyLeaveForm.getLeaveType());
		applyLeave.setComment(applyLeaveForm.getComment());
		applyLeave.setFull_half(applyLeaveForm.getFull_half());
		applyLeave.setFromDate(applyLeaveForm.getFromDate());
		applyLeave.setToDate(applyLeaveForm.getToDate());
		applyLeave.setManager_approval(applyLeaveForm.getManager_approval());
		applyLeave.setHr_approval(applyLeaveForm.getHr_approval());
//		applyLeave.setEmergencyNumber(applyLeaveForm.getEmergencyNumber());
//		applyLeave.setAvailableCall(applyLeaveForm.getAvailableCall());
		applyLeave.setCreated_on(LocalDateTime.now());
//	applyLeave.setModified_on(LocalDateTime.now());
		applyLeave.setStatus("Applied");
//	applyLeave.setUser_id(applyLeaveForm.getUser_id());
		applyLeave.setNo_of_Days(diff(applyLeaveForm.getFromDate(), applyLeaveForm.getToDate(),applyLeaveForm.getFull_half()));
		applyLeave.setLeave_Balance_Days(getLeaveBal(id, applyLeaveForm));
		if (id != null) {
			checkSaveLeaveApply = applyLeaveDao.saveApplyLeave(applyLeave);

			return checkSaveLeaveApply;
		} else {
			return false;
		}
	}

	public String diff(String start_date, String end_date ,String dayType) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {

			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);
			long difference_In_Time = d2.getTime() - d1.getTime();

			long difference_In_Days =( (difference_In_Time / (1000 * 60 * 60 * 24)) % 365)+1;
			if(dayType.equalsIgnoreCase("Full Day")){
			String str = Long.toString(difference_In_Days);

			return str;
			}else {
			double	noOfHalfDys =difference_In_Days*0.5;
	         String noOfHalfDays2=Double.toString(noOfHalfDys);
	        		 return noOfHalfDays2;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ApplyLeave> getAllLeave() {

		return applyLeaveDao.getAllLeave();

	}

	@Override
	public boolean managerApproved(Long uersId, ApplyLeaveForm applyLeaveForm) {
		ApplyLeave applyLeave = new ApplyLeave();

		applyLeave.setManager_approval(applyLeaveForm.getManager_approval());
		checkSaveLeaveApply = applyLeaveDao.managerApproved(uersId, applyLeave);
		return checkSaveLeaveApply;

	}

	@Override
	public boolean hrApproved(Long uersId, com.varaisys.intranet.utils.ApplyLeaveForm applyLeaveForm) {
		ApplyLeave applyLeave = new ApplyLeave();

		applyLeave.setHr_approval(applyLeaveForm.getStatus());
		checkSaveLeaveApply = applyLeaveDao.hrApproved(uersId, applyLeave);
		return checkSaveLeaveApply;

	}

	@Override
	public boolean FinalApproved(Long id, ApplyLeaveForm applyLeaveForm) {
		ApplyLeave applyLeave = applyLeaveDao.getmyApplyLeave(id);
         System.out.println("emp id"+ applyLeave.getEmployeeId());
         String empId= applyLeave.getEmployeeId();
		applyLeave.setStatus(applyLeaveForm.getStatus());
		applyLeave.setModified_on(LocalDateTime.now());
//		applyLeave.setLeave_Balance_Days(getLeaveBal(id, applyLeaveForm));
		checkSaveLeaveApply = applyLeaveDao.FinalApproved(id, applyLeave);
		entitlementServiceImp.updateLeaveBal(empId,id);
		return checkSaveLeaveApply;

	}
	@Override
	public boolean reject(Long id, ApplyLeaveForm applyLeaveForm) {
		ApplyLeave applyLeave = applyLeaveDao.getmyApplyLeave(id);
         System.out.println("emp id"+ applyLeave.getEmployeeId());
         String empId= applyLeave.getEmployeeId();
		applyLeave.setStatus(applyLeaveForm.getStatus());
		applyLeave.setModified_on(LocalDateTime.now());
//		applyLeave.setLeave_Balance_Days(getLeaveBal(id, applyLeaveForm));
		checkSaveLeaveApply = applyLeaveDao.FinalApproved(id, applyLeave);
	
		return checkSaveLeaveApply;

	}
	

	public float getLeaveBal(  String userId ,ApplyLeaveForm applyLeaveForm) {
		try {

			System.out.println(applyLeaveForm.getLeaveType());
			String leaveType = applyLeaveForm.getLeaveType();
			String sickLeave = "Sick Leave";

			if (leaveType.equalsIgnoreCase(sickLeave)) {

				return entitlementServiceImp.getSickLeaveBal(userId);

			} else if (leaveType.equalsIgnoreCase("Earned Leave")) {
				return entitlementServiceImp.getEarnLeaveBal(userId);
			} else if (leaveType.equalsIgnoreCase("Casual Leave")) {
				return entitlementServiceImp.getCalusalLeaveBal(userId);
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public String getNoOfDays(Long id) {

		return applyLeaveDao.getNoOfDays(id);
	}

	@Override
	public String getLeaveType(Long id) {

		return applyLeaveDao.getLeaveType(id);
	}

	public String getEmployeeId(Long id) {

		return userServicesImp.getEmpId(id);
	}
	public String getName(String id) {
		UserInfo userInfo = userServicesImp.getEmpName(id);
		return userInfo.getEmployeeName();
	}

	@Override
	public List<ApplyLeave> getAllAppliedLeave() {

//		List<ApplyLeaveForm> allLeave = applyLeaveDao.getAllAppliedLeave().stream()
//				.map(leave -> modelMapper.map(leave, ApplyLeaveForm.class)).collect(Collectors.toList());
//
//		return allLeave;
		return applyLeaveDao.getAllAppliedLeave();

	}
	public String setEmpName(ApplyLeaveForm applyLeave) {
		List<ApplyLeave> allLeave = applyLeaveDao.getAllAppliedLeave();
		for (ApplyLeave allLeaves : allLeave)

		{

			String empCode = allLeaves.getEmployeeId();

			System.out.println(empCode + " emp code");
			if (empCode != null) {
				UserInfo name = userServicesImp.getNameByEmpCode(empCode);
				String employeeName = name.getEmployeeName();

				return employeeName;
			}

		}
		return null;
	}

	@Override
	public ApplyLeave getMyLeave(Long id) {
	
		return applyLeaveDao.getmyApplyLeave(id);
	}
	

	@Override
	public boolean updateApplyLeave(ApplyLeaveForm applyLeaveForm) {
		ApplyLeave applyLeave = new ApplyLeave();

	    applyLeave.setStatus(applyLeaveForm.getStatus());
		applyLeave.setModified_on(LocalDateTime.now());
		
		checkSaveLeaveApply = applyLeaveDao.approve(applyLeave);
	
		return checkSaveLeaveApply;
		
		
	}

	@Override
	public boolean saveAssignLeave(ApplyLeaveForm applyLeaveForm) {
		if(applyLeaveForm!=null) {
		ApplyLeave applyLeave = new ApplyLeave();
System.out.println(applyLeaveForm.getEmployeeName());
		applyLeave.setEmployeeId(applyLeaveForm.getEmployeeId());
		applyLeave.setEmployeeName(applyLeaveForm.getEmployeeName());
		applyLeave.setLeaveType(applyLeaveForm.getLeaveType());
		applyLeave.setComment(applyLeaveForm.getComment());
		
		applyLeave.setFromDate(applyLeaveForm.getFromDate());
		applyLeave.setToDate(applyLeaveForm.getToDate());
		
	
		applyLeave.setCreated_on(LocalDateTime.now());

		applyLeave.setStatus("Assign Leave");

		applyLeave.setNo_of_Days(diff(applyLeaveForm.getFromDate(), applyLeaveForm.getToDate(),applyLeaveForm.getFull_half()));
	
		
			checkSaveLeaveApply = applyLeaveDao.saveApplyLeave(applyLeave);

			return checkSaveLeaveApply;
		} else {
			return false;
		}
	
	}

	@Override
	public ApplyLeave getApplyLeaveByLeaveId(Long id) {
		// TODO Auto-generated method stub
		return applyLeaveDao.getApplyLeaveByLeaveId(id);
	}
}
