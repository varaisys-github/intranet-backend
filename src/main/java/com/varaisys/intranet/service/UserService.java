package com.varaisys.intranet.service;

import java.util.List;
/**
 * 
 * @author Sachin Kashyap
 * @Created on 11-nov-2022
 * @modify on 14-nov-2022
 */
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.utils.TokenData;
import com.varaisys.intranet.utils.UserInfoForm;
public interface UserService {
	
		public boolean saveUser(UserInfoForm userInfoForm);
		public List<UserInfo>getAllUserList();
		public UserInfo getUserById(Long id);
		public void deleteUserById(Long id);
		public boolean updateUser(UserInfoForm userInfoForm);
		public String saveToken(String token);
		public boolean updateUserPassword(TokenData tokenData);
		/**
 * 
 * @author Madhu Kumari
 

 */
		public UserInfo getEmpName(String id);
		public String getEmpId(Long id);
		public UserInfo getNameByEmpCode(String empId);
		public List<UserInfo> getEmpName() ;
		
}
