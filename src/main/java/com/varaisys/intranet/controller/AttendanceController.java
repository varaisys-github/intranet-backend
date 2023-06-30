package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import com.varaisys.intranet.model.AttendanceDataModel;
import com.varaisys.intranet.service.AttendanceService;
import com.varaisys.intranet.utils.AttendanceData;

/**
 * 
 * @author Babli Singh
 * @Created on 16/feb/2023
 * @Created on 16-feb-2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;

	@RequestMapping(value = "/addAttendance", method = RequestMethod.POST)
	public ResponseEntity<?> addAttendance(@RequestBody AttendanceData AttendanceData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boolean f = attendanceService.addAttendance(AttendanceData);
			if (f) {
				map.put("message", "Attendance Add successfully");
			}
			return ResponseEntity.ok().body(map);
		} catch (Exception e) {
			System.out.println("error --" + e);

		}
		return ResponseEntity.badRequest().body("something wrong");

	}

	@RequestMapping(value = "/getAttendanceDetail", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAttendanceTime() {
		Map<String, Object> map = new HashMap<>();
		List<AttendanceDataModel> attendanceDataModel = attendanceService.getAttendanceData();
		try {
			
			
			if (attendanceDataModel == null) {
				map.put("details", "No Details Present");
			} else {
				map.put("Attendance_Data", attendanceDataModel);
				return ResponseEntity.ok().body(map);
			}
			
		} catch (Exception e) {
			System.out.println("error -"+ e);
		}
		
		return ResponseEntity.badRequest().body(map);

	}

}
