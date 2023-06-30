package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.serviceImpl.MyLeaveServiceImp;
import com.varaisys.intranet.serviceImpl.UserServiceImpl;
import com.varaisys.intranet.utils.MyLeavePaylod;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class MyLeaveController {
	@Autowired
	MyLeaveServiceImp myLeaveServiceImp;
	@Autowired UserServiceImpl userServicesImp;
	@GetMapping("/myAllLeave/{userId}")
	public ResponseEntity<?> getApplyLeaveById(@PathVariable String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		List<?> applyleave = myLeaveServiceImp.myLeaveById(userId);
		System.out.println("My Leave controller");
		 UserInfo name =userServicesImp.getEmpName(userId);
		if ( applyleave.isEmpty()) {
			System.out.println(applyleave);
			map.put("message", "Details  not found");
			return ResponseEntity.ok().body(map);
		     } else {
			map.put("myLeave", applyleave);
			map.put("name", name.getEmployeeName());
			return ResponseEntity.ok().body(map);
		   }
		  } catch (Exception e) {
			  e.printStackTrace();
			map.put("message", "Id not match ");
			
			return ResponseEntity.badRequest().body(map);
		   }

	}
	
	@PostMapping("/getMyLeave/{userId}")
	public ResponseEntity<?> getMyLeave(@PathVariable Long userId, @RequestBody MyLeavePaylod myLeavePaylod){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ApplyLeave>  applyleave = myLeaveServiceImp.getMyLeave( userId ,myLeavePaylod);
		try {
			
			if (userId!=0) {
				map.put("myLeave", applyleave);
				
				return ResponseEntity.ok().body(map);
			} else {
				map.put("Message", " provide valid details");
				return ResponseEntity.ok().body(map);
			}
			

		} catch (Exception e) {
			map.put("message", "something Wrong");

			return ResponseEntity.badRequest().body(map);
		}
		
	}
	
	}




