package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.varaisys.intranet.model.JobsTitles;
import com.varaisys.intranet.model.MyInfoFileupload;
import com.varaisys.intranet.serviceImpl.JobsTitlesServiceImpl;
import com.varaisys.intranet.utils.JobsTitlesForm;
/**
 * 
 * @author Sachin Kashyap
 * @Created on 11-nov-2022
 *@modify on 14-nov-2022
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class JobsTitlesConroller {
@Autowired
JobsTitlesServiceImpl jobsTitlesServiceImpl;
@RequestMapping(value="/saveJobTitles" ,method = RequestMethod.POST)
public ResponseEntity<?>saveJobTitles(@ModelAttribute("form") @Valid JobsTitlesForm form, BindingResult result) 
{   Map<String, Object> map = new HashMap<String, Object>();
	try {
		if(form==null) {
			 map.put("message","Please Provide Details");
		}
		else
		{
			
			 jobsTitlesServiceImpl.saveJobsTitles(form);
			 map.put("message","Job Titles Saved");
		}
	} catch (Exception e) {
		 
	}
	  return ResponseEntity.ok().body(map); 
	
}
@RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
public ResponseEntity<?> getFiles() {

	Map<String, Object> map = new HashMap<String, Object>();
	List<JobsTitles> allJobs = jobsTitlesServiceImpl.getAllJobTitles();
	if (allJobs != null) {
		map.put("Files", allJobs);
	} else {
		map.put("MESSAGE", "No Job Titles");
	}
	return ResponseEntity.ok().body(map);
}
}
