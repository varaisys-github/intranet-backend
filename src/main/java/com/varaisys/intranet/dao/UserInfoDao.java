package com.varaisys.intranet.dao;

import java.util.List;
import com.varaisys.intranet.model.UserInfo;

/**
 * 
 * @author Sachin Kashyap
 * @created on 11-nov-2022
 * @modify on 14-nov-2022
 */
public interface UserInfoDao {
	public boolean saveUser(UserInfo userInfo);

	public List<UserInfo> getAllUser();

	public UserInfo getUserById(Long id);

	public void deleteUserById(Long id);

	public UserInfo userByCriteria(String userName, String role, String emoloyeeName, String status,String userEmail,String token);
	/**
 * 
 * @author Madhu Kumari
 

 */
	public UserInfo getEmpName(String id);
public UserInfo getEmpId(Long id);
public UserInfo getNameByEmpCode(String empId);
public List <UserInfo> getEmpName();

}
