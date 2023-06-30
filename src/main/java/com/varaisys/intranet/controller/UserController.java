package com.varaisys.intranet.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.UserService;
import com.varaisys.intranet.serviceImpl.EntitlementServicesImp;
import com.varaisys.intranet.serviceImpl.UserServiceImpl;
import com.varaisys.intranet.utils.EntitlementForm;
import com.varaisys.intranet.utils.UserInfoForm;
/**
 * 
 * @author Sachin Kashyap
 * @created on 07/nov/2022
 *@modify Date 14/nov/2022
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImp;
	@Autowired EntitlementServicesImp entitlementServicesImp; 

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UserInfoForm userInfoForm) {

		Map<Object, Object> map = new HashMap<>();
		EntitlementForm entitlementForm = new EntitlementForm();
		if (userInfoForm == null) {
			map.put("Message", "Please provide the details");
		}
		if (userInfoForm != null) {
			boolean f = userServiceImp.saveUser(userInfoForm);
		entitlementForm.setEmployeeName(userInfoForm.getEmployeeName());
		entitlementForm.setEmployeeId(userInfoForm.getEmployeeCode());
			boolean checkSaveApplyLeave = entitlementServicesImp.saveEnt(entitlementForm);
			if (f) {
				map.put("message", userInfoForm);
			}
		}
		return ResponseEntity.ok().body(map);
	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public ResponseEntity<?> getUser() {
		Map<Object, Object> map = new HashMap<>();
		List<UserInfo> users = userServiceImp.getAllUserList();
		if (users == null) {
			map.put("details", "No Details Present");
		} else {
			map.put("users", users);
		}
		return ResponseEntity.ok().body(map);

	}

	@RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		Map<Object, Object> map = new HashMap<>();
		if (id == null) {
			map.put("message", "Please Provide Id");
			return ResponseEntity.ok().body(map);
		} else {
			UserInfo user = userServiceImp.getUserById(id);
			if (user == null) {
				map.put("message", "Details are  not Available");
				return ResponseEntity.ok().body(map);
			}
			map.put("details", user);
		}
		return ResponseEntity.ok().body(map);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @created on 10-nov/2022
	 * @modify on 14/nov/2022
	 */
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteuser(@PathVariable Long id) {
		Map<Object, Object> map = new HashMap<>();
		if (id == null || id == 0) {
			map.put("Message", "Please provide the id");
			return ResponseEntity.ok().body(map);
		}
		if (id != null) {
			userServiceImp.deleteUserById(id);
			map.put("Message", "User Deleted Successfully");
		}
		return ResponseEntity.ok().body(map);

	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody UserInfoForm userInfoForm) {

		Map<Object, Object> map = new HashMap<>();
		if (userInfoForm == null) {
			map.put("Message", "Please provide the details");
		}
		if (userInfoForm!= null) {
			boolean f = userServiceImp.updateUser(userInfoForm);
			if (f) {
				map.put("message", "User Updated Successfully");
			}
		}
		return ResponseEntity.ok().body(map);
	}
}
