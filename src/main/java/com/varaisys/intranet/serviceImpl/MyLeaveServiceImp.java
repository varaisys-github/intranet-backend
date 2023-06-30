package com.varaisys.intranet.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.ApplyLeaveDao;
import com.varaisys.intranet.dao.MyLeaveDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.MyLeaveService;
import com.varaisys.intranet.utils.ApplyLeaveForm;
import com.varaisys.intranet.utils.MyLeavePaylod;
@Service()
@Transactional("mydb")
public class MyLeaveServiceImp implements MyLeaveService{

	@Autowired
	ApplyLeaveDao applyLeaveDao;
	@Autowired
	MyLeaveDao myLeaveDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	@Override
	
	public List<?> myLeaveById(String id) {
		return myLeaveDao.myLeaveById(id);
		
	}
	@Override
	public List<ApplyLeave> getMyLeave( Long userId ,MyLeavePaylod myLeavePaylod) {
		System.out.println("service imp");
		
		System.out.println(myLeavePaylod);
		return myLeaveDao.getMyLeave( userId, myLeavePaylod);
		
	}
	
	
}
