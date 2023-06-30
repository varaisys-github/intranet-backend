package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.varaisys.intranet.model.ApplyLeave;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.ApplyLeaveService;
import com.varaisys.intranet.service.EntitlementServices;
import com.varaisys.intranet.serviceImpl.ApplyLeaveServiceImp;
import com.varaisys.intranet.serviceImpl.EntitlementServicesImp;
import com.varaisys.intranet.serviceImpl.UserServiceImpl;
import com.varaisys.intranet.utils.ApplyLeaveForm;

/**
 * @Author Madhu kumari
 * @CreationDate - 18-01-2023
 * @Desc - apply leave Controller
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ApplyLeaveController {
	@Autowired
	ApplyLeaveService applyLeaveServiceImp;
	@Autowired
	EntitlementServices entitlementServicesImp;
	@Autowired
	UserServiceImpl userServiceImp;

	@PostMapping("/saveLeave/{userId}")
	public ResponseEntity<?> saveApplyLeave(@PathVariable String  userId,
			@RequestBody ApplyLeaveForm applyLeaveForm) {
		Map<Object, Object> map = new HashMap<>();
		System.out.println(userId);
		try {
			if (applyLeaveForm != null) {
				System.out.println(applyLeaveForm.getFromDate()+"date");
				System.out.println(applyLeaveForm.getToDate()+applyLeaveForm.getFull_half());
				boolean checkSaveApplyLeave = applyLeaveServiceImp.saveApplyLeave(userId, applyLeaveForm);
				System.out.println("apply Leavecontroller1");
			
				if (checkSaveApplyLeave) {
					System.out.println("true");
					map.put("message", "applied successfully");
					System.out.println("apply Leavecontroller2");
					return ResponseEntity.ok().body(map);
				} else {
					System.out.println("false");
					map.put("message", "please provide valid Id");
					return ResponseEntity.ok().body(map);
				}
			} else {
				map.put("message", "please provide details ");
				return ResponseEntity.ok().body(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "something Wrong");

			return ResponseEntity.badRequest().body(map);
		}
	}

	@GetMapping("/getAllLeave")

	public ResponseEntity<?> getAllApplyLeave() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ApplyLeave> allApplyLeave = applyLeaveServiceImp.getAllLeave();

			if (allApplyLeave == null) {
				map.put("details", "No Details Present");
				return ResponseEntity.ok().body(map);
			} else {
				map.put("allLeave", allApplyLeave);

				return ResponseEntity.ok().body(map);
			}

		} catch (Exception e) {
			map.put("Apply Leave", "something wrong");
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}

	@GetMapping("/getMyLeave/{id}")

	public ResponseEntity<?> getAllMyLeave( @PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		ApplyLeave applyLeave= applyLeaveServiceImp.getMyLeave(id);

			if (applyLeave == null) {
				map.put("details", "No Details Present");
				return ResponseEntity.ok().body(map);
			} else {
				map.put("myLeave", applyLeave);

				return ResponseEntity.ok().body(map);
			}

		} catch (Exception e) {
			map.put("Apply Leave", "something wrong");
			e.printStackTrace();
			return ResponseEntity.ok().body(map);
		}
	}
	@GetMapping("/getLeaveById/{id}")

	public ResponseEntity<?> getLeave( @PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		ApplyLeave applyLeave= applyLeaveServiceImp.getApplyLeaveByLeaveId(id);

			if (applyLeave == null) {
				map.put("details", "No Details Present");
				return ResponseEntity.ok().body(map);
			} else {
				map.put("myLeave`", applyLeave);

				return ResponseEntity.ok().body(map);
			}
			}catch (Exception e) {
				map.put("Apply Leave", "something wrong");
				e.printStackTrace();
				return ResponseEntity.ok().body(map);
			}
		}
		

	@GetMapping("/getAllAppliedLeave")

	public ResponseEntity<?> getAllAppliedLeave() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		    System.out.println("controller classs running");
			List<ApplyLeave> allApplyLeave = applyLeaveServiceImp.getAllAppliedLeave();
       
			if (allApplyLeave == null) {
				map.put("details", "No Details Present");
				return ResponseEntity.ok().body(map);
			} else {
				map.put("allLeave", allApplyLeave);
				

				return ResponseEntity.ok().body(map);
			}

		} catch (Exception e) {
			map.put("Apply Leave", "something wrong");
			e.printStackTrace();
			return ResponseEntity.badRequest().body(map);
		}
	}

	@PutMapping("/hrApproved/{id}")
	public ResponseEntity<?> hrApproval(@RequestBody ApplyLeaveForm applyLeaveForm, @PathVariable Long id) {
		System.out.println("message");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (applyLeaveForm.getStatus() != null) {
				boolean checkApplyUpdate = applyLeaveServiceImp.hrApproved(id, applyLeaveForm);
				if (checkApplyUpdate) {
					map.put("Uadate success", applyLeaveForm.getHr_approval());
				}
			}
			return ResponseEntity.ok().body(map);

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
	}

	@PutMapping("/managerApproval/{id}")
	public ResponseEntity<?> managerApproval(@RequestBody ApplyLeaveForm applyLeaveForm, @PathVariable Long id) {
		System.out.println("message");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (applyLeaveForm.getStatus() != null) {
				boolean checkApplyUpdate = applyLeaveServiceImp.managerApproved(id, applyLeaveForm);
				if (checkApplyUpdate) {
					map.put("Uadate success", applyLeaveForm.getManager_approval());
				}
			}
			return ResponseEntity.ok().body(map);

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
	}

	@PutMapping("/finalApproval/{id}")
	public ResponseEntity<?> finalApproval(@RequestBody ApplyLeaveForm applyLeaveForm, @PathVariable Long id) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (applyLeaveForm.getStatus() != null) {

				boolean checkApplyUpdate = applyLeaveServiceImp.FinalApproved(id, applyLeaveForm);

				if (checkApplyUpdate) {
				
					map.put("Update success", applyLeaveForm.getStatus());
				}
			}
			return ResponseEntity.ok().body(map);

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
	}
	@PutMapping("/reject/{id}")
	
	public ResponseEntity<?> reject(@RequestBody ApplyLeaveForm applyLeaveForm, @PathVariable Long id) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if (applyLeaveForm.getStatus() != null) {

				boolean checkApplyUpdate = applyLeaveServiceImp.FinalApproved(id, applyLeaveForm);

				if (checkApplyUpdate) {
				
					map.put("Update success", applyLeaveForm.getStatus());
				}
			}
			return ResponseEntity.ok().body(map);
			

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
	}
	@PostMapping("/assignleave")
	public ResponseEntity<?> assign(@RequestBody ApplyLeaveForm applyLeaveForm) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if (applyLeaveForm!= null) {

				boolean checkAssignleave = applyLeaveServiceImp.saveAssignLeave(applyLeaveForm);

				if (checkAssignleave) {
				
					map.put("Leave Assign", applyLeaveForm);
				}
			}
			return ResponseEntity.ok().body(map);
			

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
	}

}
