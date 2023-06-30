package com.varaisys.intranet.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.varaisys.intranet.service.SkillService;
import com.varaisys.intranet.utils.SkillsForm;
import com.varaisys.intranet.model.SkillsDetails;

/**
 *
 * @author Kanishka Rajput
 * @Created on 20/mar/2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")


public class SkillsController {
    @Autowired
    SkillService skillService;
    @RequestMapping(value = "/Addskills", method = RequestMethod.POST)
    public ResponseEntity<?>addskills(@RequestBody SkillsForm skillsForm){
        Map<Object,Object>map =new HashMap<>();
        System.out.println(skillsForm + "++++++++++++++++kanishkaaa");
        if (skillsForm == null) {
            map.put("Message", "Please provide the details");
        }
        if (skillsForm != null) {
            System.out.println("form not null");
            boolean f = skillService.Addskills(skillsForm);
            if (f) {
                map.put("message", skillsForm);
            }
        }
        return ResponseEntity.ok().body(map);
    } 
    @RequestMapping(value = "/getskills", method = RequestMethod.GET)
    public ResponseEntity<?>getskills(@RequestBody SkillsForm skillsForm){
        System.out.println("this is on working.................");
        Map<Object,Object>map =new HashMap<>();
        List<SkillsDetails> skillsDetails = skillService.getskills();
        // System.out.println("this is on working................."+skillService.getskills() );
        if (skillsDetails == null) {
            map.put("skillsDetails", "No Details Present");
        } else {
            map.put("skillsDetails",skillsDetails);
        }
        return ResponseEntity.ok().body(map);

}
}

