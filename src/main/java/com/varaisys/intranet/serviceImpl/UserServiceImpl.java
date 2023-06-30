package com.varaisys.intranet.serviceImpl;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.TokenValidationDao;
import com.varaisys.intranet.dao.UserInfoDao;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.TokenValidationService;
import com.varaisys.intranet.service.UserService;
import com.varaisys.intranet.utils.TokenData;
import com.varaisys.intranet.utils.UserInfoForm;

/**
 * 
 * @author Sachin Kashyap
 * @Created on 11-nov-2022
 * @modify on 14-nov-2022
 */
@Service()
@Transactional("mydb")
public class UserServiceImpl implements UserService {
	private boolean flag = false;
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	StringBuilder sb = new StringBuilder();
	Random random = new Random();
	int length = 7;
	@Autowired
	TokenValidationService tokenValidationService;
	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	TokenValidationDao tokenValidationDao;

	@Override
	public boolean saveUser(UserInfoForm userInfoForm) {
		UserInfo userInfo = new UserInfo();
		userInfo.setEmployeeName(userInfoForm.getEmployeeName());
		userInfo.setPassword(userInfoForm.getPassword());
		userInfo.setRole(userInfoForm.getRole());
		userInfo.setStatus(userInfoForm.getStatus());
		userInfo.setUserName(userInfoForm.getUserName());
		userInfo.setCreatedDate(LocalDateTime.now());
		userInfo.setUserEmail(userInfoForm.getUserEmail());
		flag = userInfoDao.saveUser(userInfo);
		return flag;
	}

	@Override
	public UserInfo getUserById(Long id) {
		UserInfo user = userInfoDao.getUserById(id);
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		UserInfo user = userInfoDao.getUserById(id);
		user.setStatus("Deleted");
		user.setDeletedDate(LocalDateTime.now());

	}

	@Override
	public List<UserInfo> getAllUserList() {

		return userInfoDao.getAllUser();
	}

	@Override
	public boolean updateUser(UserInfoForm userInfoForm) {
		boolean fla = false;
		UserInfo userInfo = userInfoDao.getUserById(userInfoForm.getUserId());
		if (userInfo != null) {
			userInfo.setEmployeeName(userInfoForm.getEmployeeName());
			userInfo.setPassword(userInfoForm.getPassword());
			userInfo.setRole(userInfoForm.getRole());
			userInfo.setStatus(userInfoForm.getStatus());
			userInfo.setModifyDate(LocalDateTime.now());
			flag = true;
		}
		return fla;
	}

	@Override
	public String saveToken(String token) {
		UserInfo userInfo = new UserInfo();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		userInfo.setToken(randomString);
		flag = userInfoDao.saveUser(userInfo);

		return randomString;
	}
	
	
	@Override
	public boolean updateUserPassword(TokenData token) {
		boolean fla = true;
		UserInfo userInfo = tokenValidationService.findByToken(token.getToken());
		
		if (userInfo != null) {
			System.out.println("userInfo data ---" + userInfo.getPassword());
			userInfo.setPassword(token.getPassword());
			flag = false;
		}
		return fla;
	}
	@Override
	public UserInfo getEmpName(String  id) {
		return userInfoDao.getEmpName(id);
				
	}

	@Override
	public String getEmpId(Long id) {
		try {
			UserInfo  empcode=userInfoDao.getEmpId(id);
			
			return  empcode.getEmployeeId();
		} catch (Exception e) {
			System.out.println("EmployeeId is null or not matched");
			return null;
		}
		
		
	}

	@Override
	public UserInfo getNameByEmpCode(String empId) {
		return userInfoDao.getNameByEmpCode(empId);
		
	}

	@Override
	public List<UserInfo> getEmpName() {
	
		return userInfoDao.getEmpName();
	}
	

}
