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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.model.AddEntitlement;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.serviceImpl.EntitlementServicesImp;
import com.varaisys.intranet.serviceImpl.UserServiceImpl;
import com.varaisys.intranet.utils.ApplyLeaveForm;
import com.varaisys.intranet.utils.EntitlementForm;
/**
 * @Author Madhu Kumari
 * @CreationDate -08-02-2023
  * @Desc - Entitlement Controller
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class EntitlementController {
	@Autowired
	EntitlementServicesImp entitlementServicesImp;
	@Autowired
	UserServiceImpl userServiceImp;

	@PostMapping("/entitlement")
	public ResponseEntity<?> saveEnt(@RequestBody EntitlementForm entitlementForm) {
		Map<Object, Object> map = new HashMap<>();

		try {
			if (entitlementForm != null) {
				boolean checkSaveApplyLeave = entitlementServicesImp.saveEnt(entitlementForm);
				if (checkSaveApplyLeave) {
					map.put("message", entitlementForm);
				}
			} else {
				map.put("message", "something wrong ");
			}
			return ResponseEntity.ok().body(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "something Wrong");

			return ResponseEntity.ok().body(map);
		}
	}
	@GetMapping("/getMyEnt/{id}")
	public ResponseEntity<?> getMyEnt(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			AddEntitlement myEnt = entitlementServicesImp.getMyEnt(id);

			map.put("entitlement", myEnt);
			return ResponseEntity.ok().body(map);

		} catch (Exception e) {
			map.put("message", "something wrong");
			return ResponseEntity.ok().body(map);
		}
	}

	@GetMapping("/getAllEnt")

	public ResponseEntity<?> getAllEnt() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<AddEntitlement> allEnt = entitlementServicesImp.getAllEnt();

			map.put("entitlement", allEnt);
			return ResponseEntity.ok().body(map);

		} catch (Exception e) {
			map.put("message", "something wrong");
			return ResponseEntity.ok().body(map);
		}
	}

	@GetMapping("/getMyLeaveBal/{id}")

	public ResponseEntity<?> getMyLeavenBal(@PathVariable String  id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			List<AddEntitlement> allEnt = entitlementServicesImp.getMyLeaveBal(id);
			map.put("entitlement", allEnt);
			return ResponseEntity.ok().body(map);
		} catch (Exception e) {

			map.put("entitlement", "error");
			System.out.println(e);
			return ResponseEntity.ok().body(map);

		}

	}
	@PutMapping("/addEntitlement/{id}")
	public ResponseEntity<?> updateEnt(@RequestBody EntitlementForm entitlementForm, @PathVariable Long id) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
				if((entitlementForm.getCausalLeave()!=0)||(entitlementForm.getEarnLeave()!=0)||(entitlementForm.getSickLeave()!=0)) {
				System.out.println("success Update ent 1");
				boolean checkEntUpdate =  entitlementServicesImp.updateEnt(id, entitlementForm);

				if (checkEntUpdate) {
				System.out.println("success Update ent 2");
					map.put("message", entitlementForm);
				}
				
			}else {
				map.put("message", "Provide The Valid Date");
			}
			return ResponseEntity.ok().body(map);
			

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
		
	}
	
	@GetMapping("/getAllEmployeeName")
	public ResponseEntity<?>getEmployeeName() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
				
				List<UserInfo> employeeName = userServiceImp.getEmpName();
				
				map.put("employeeName",employeeName);
			
				return ResponseEntity.ok().body(map);
			
			

		} catch (Exception e) {
			map.put("message", "wrong Try again");
			System.out.println(e);
			return ResponseEntity.ok().body(map);
		}
	}
	}
//	@GetMapping("/getSickLeaveBal/{id}")
//
//	public ResponseEntity<?> getSickLeaveBal(@PathVariable Long id) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//
//			float allEnt = entitlementServicesImp.getSickLeaveBal(id);
//			map.put("entitlement", allEnt);
//			return ResponseEntity.ok().body(map);
//		} catch (Exception e) {
//			
//			map.put("entitlement", "error");
//			System.out.println(e);
//			return ResponseEntity.ok().body(map);
//
//		}
//
//	}

//	@GetMapping("/getCausalLeaveBal/{id}")

//	public ResponseEntity<?> getCausalLeavenBal(@PathVariable Long id) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//
//			float allEnt = entitlementServicesImp.getCalusalLeaveBal(id);
//			map.put("entitlement", allEnt);
//			return ResponseEntity.ok().body(map);
//		} catch (Exception e) {
//			// TODO: handle exception
//			map.put("entitlement", "error");
//			System.out.println(e);
//			return ResponseEntity.ok().body(map);
//
//		}
//
//	}

//	@GetMapping("/getEarnLeaveBal/{id}")
//
//	public ResponseEntity<?> getLeavenBal(@PathVariable Long id) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//
//			float allEnt = entitlementServicesImp.getEarnLeaveBal(id);
//			map.put("entitlement", allEnt);
//			return ResponseEntity.ok().body(map);
//		} catch (Exception e) {
//			// TODO: handle exception
//			map.put("entitlement", "error");
//			System.out.println(e);
//			return ResponseEntity.ok().body(map);
//
//		}

//	}

