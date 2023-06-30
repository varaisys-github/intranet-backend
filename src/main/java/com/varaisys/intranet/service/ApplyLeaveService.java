package com.varaisys.intranet.service;

import java.util.List;

import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.utils.ApplyLeaveForm;

public interface ApplyLeaveService {

	public boolean saveApplyLeave( String userId ,ApplyLeaveForm applyLeaveForm);
	public List<ApplyLeave> getAllLeave();
	public List<ApplyLeave> getAllAppliedLeave();
	public ApplyLeave getMyLeave(Long id);
	public ApplyLeave getApplyLeaveByLeaveId(Long id) ;
	public boolean managerApproved( Long uersId ,ApplyLeaveForm applyLeaveForm);
//	public List<ApplyLeave> getLeaveByUser(Long userId) ;
	public boolean hrApproved( Long uersId ,ApplyLeaveForm applyLeaveForm);
	public boolean FinalApproved( Long uersId ,ApplyLeaveForm applyLeaveForm);
	public String getNoOfDays(Long id) ;
   public boolean updateApplyLeave(ApplyLeaveForm applyLeaveForm);
  	public String getLeaveType(Long id);
  	public boolean reject( Long uersId ,ApplyLeaveForm applyLeaveForm);
	public boolean saveAssignLeave( ApplyLeaveForm applyLeaveForm);
}
