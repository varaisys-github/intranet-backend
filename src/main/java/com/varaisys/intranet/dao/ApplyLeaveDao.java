package com.varaisys.intranet.dao;
import java.util.List;

import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.utils.ApplyLeaveForm;
public interface ApplyLeaveDao {
//apply method
public boolean saveApplyLeave( ApplyLeave applyLeave);
public List<ApplyLeave> getAllLeave();
public ApplyLeave getmyApplyLeave(Long id);
public ApplyLeave getApplyLeaveByLeaveId(Long id);
public List<ApplyLeave> getAllAppliedLeave();

public boolean managerApproved( Long uersId ,ApplyLeave applyLeave);
//public List<ApplyLeave> getLeaveByUser(Long userId) ;
public boolean hrApproved( Long uersId ,ApplyLeave applyLeave);
public boolean FinalApproved( Long uersId ,ApplyLeave applyLeave);
public float getLeaveBal(Long id) ;
public String getNoOfDays(Long id ) ;

public String getLeaveType(Long id);

public boolean approve(ApplyLeave applyLeave);
public String getEmpCodeByeaveId(Long id);
public boolean saveAssignLeave( ApplyLeave applyLeave);



}
