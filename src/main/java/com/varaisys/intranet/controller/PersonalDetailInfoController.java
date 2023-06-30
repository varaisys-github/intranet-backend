package com.varaisys.intranet.controller;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;

import com.varaisys.intranet.model.PersonalDetails;
import com.varaisys.intranet.serviceImpl.PersonalDetailServiceImpl;
import com.varaisys.intranet.utils.PersonalDetailForm;

/**
 * 
 * @author Babli Singh
 * @Created on 20/jan/2023
 * @Created on 20-jan-2023
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class PersonalDetailInfoController {

	@Autowired
	private PersonalDetailServiceImpl personalDetailServiceIMp;

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public ResponseEntity<?> addPerson(@Valid @RequestBody PersonalDetailForm personalDetailform,
			BindingResult bindingResult, Error error) throws PersonNotFoundException {
		System.out.println(personalDetailform + "++++++++++++++++++");
		Map<String, Object> map = new HashMap<String, Object>();
//		
		try {

			boolean f = personalDetailServiceIMp.addPerson(personalDetailform);
			if (f) {
				map.put("message", "person added successfully");

			} else if (personalDetailform.getFirstName() == null) {
				map.put("message", "Please provide the firstName");
				// throw new PersonNotFoundException();

			} else if (personalDetailform.getDLNumber().length() != 15) {
				// throw new RuntimeException("Please enter DLNumber in String (DL-XXXXX)
				// format");
				map.put("message", "Please enter DLNumber length(15)");

			} else if (personalDetailform.getPanNumber().length() != 10) {
				map.put("message", "Please enter panNumber valid length(10)");
			} else if (personalDetailform.getAdharNumber().length() != 12) {
				map.put("message", "Please enter panNumber valid length(10)");
			} else {
				map.put("message", "person added successfully");
			}
		} catch (Exception e) {
			System.out.print("error" + e);
		}
		System.out.println("person details " + personalDetailform);

		return ResponseEntity.ok().body(map);
	}

	@RequestMapping(value = "/getPersonDetail", method = RequestMethod.GET)
	public ResponseEntity<?> getPersonalDetails() throws PersonNotFoundException {
		Map<String, Object> map = new HashMap<>();
		List<PersonalDetails> personalDetails = personalDetailServiceIMp.getPersonalDetails();
		if (personalDetails == null) {
			map.put("details", "No Details Present");
		} else {
			map.put("PersonDetail", personalDetails);
		}
		return ResponseEntity.ok().body(map);

	}

	@RequestMapping(value = "getPersonDetail/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<?> getPersonalDetail(@PathVariable int employeeId) throws PersonNotFoundException {
		Map<String, Object> map = new HashMap<>();
		if (employeeId == 0) {

			throw new PersonNotFoundException();

		} else {
			PersonalDetails personalDetails = personalDetailServiceIMp.getPersonalDetail(employeeId);
			if (personalDetails == null) {
				map.put("message", "Details are  not Available");
				return ResponseEntity.ok().body(map);
			}
			map.put("details", personalDetails);
		}
		return ResponseEntity.ok().body(map);
	}

	@RequestMapping(value = "/deletePersonDetail/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable int employeeId) throws PersonNotFoundException {
		Map<String, Object> map = new HashMap<>();
		if (employeeId == 0) {
			map.put("Message", "Please provide the id");
			return ResponseEntity.ok().body(map);
		}
		if (employeeId != 0) {

			personalDetailServiceIMp.deletePerson(employeeId);
			map.put("Message", "User Deleted Successfully");
		}
		return ResponseEntity.ok().body(map);

	}

	@RequestMapping(value = "/updatePersonDetail", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDetails(@RequestBody PersonalDetailForm personalDetailForm)
			throws PersonNotFoundException {

		Map<String, Object> map = new HashMap<>();
		if (personalDetailForm == null) {
			map.put("Message", "Please provide the details");
		}
		if (personalDetailForm != null) {
			boolean f = personalDetailServiceIMp.updateDetails(personalDetailForm);
			if (f) {
				map.put("message", "User Updated Successfully");
			}
		}
		return ResponseEntity.ok().body(map);
	}
}
