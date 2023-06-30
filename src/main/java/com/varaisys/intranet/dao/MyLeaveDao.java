package com.varaisys.intranet.dao;

import java.util.List;


import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.ApplyLeaveForm;
import com.varaisys.intranet.utils.MyLeavePaylod;

public interface MyLeaveDao {
	public List<?> myLeaveById(String id);
	public List<ApplyLeave> getMyLeave( Long UesrId ,MyLeavePaylod myLeavePaylod);
	public   void getLeaveBal(Long userId);
	public void delectMyLeave( Long userId);
	
}
