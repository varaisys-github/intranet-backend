package com.varaisys.intranet.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import com.varaisys.intranet.service.WorkExperienceService;
import com.varaisys.intranet.utils.WorkExperienceForm;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import com.varaisys.intranet.model.WorkExperience;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kanishka Rajput
 * @Created on 15/feb/2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class WorkExperienceController {
    @Autowired
    private WorkExperienceService workexperienceservice;

    @RequestMapping(value = "/AddExperience", method = RequestMethod.POST)
    public ResponseEntity<?> AddExperience(@RequestBody WorkExperienceForm workexperienceForm) {

        Map<Object, Object> map = new HashMap<>();
        System.out.println("kanishkaaaa----");
        System.out.println(workexperienceForm + "++++++++++++++++kanishkaaa");
        if (workexperienceForm == null) {
            map.put("Message", "Please provide the details");
        }
        if (workexperienceForm != null) {
            System.out.println("form not null");
            boolean f = workexperienceservice.AddExperience(workexperienceForm);
            if (f) {
                map.put("message", workexperienceForm);
            }
        }
        return ResponseEntity.ok().body(map);
    }

    @RequestMapping(value = "/getallExperience", method = RequestMethod.GET)
    public ResponseEntity<?> getallExperience() throws PersonNotFoundException {
        Map<String, Object> map = new HashMap<>();
        List<WorkExperience> workexperience = workexperienceservice.getallExperience();
        // System.out.println(getPersonalContacts + ",..kanishkaa");

        if (workexperience == null) {
            map.put("workexperience", "No Details Present");
        } else {
            map.put("workexperience", workexperience);
        }
        return ResponseEntity.ok().body(map);

    }

}

