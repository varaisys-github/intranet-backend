package com.varaisys.intranet.controller;

import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.model.Dependents;
import com.varaisys.intranet.service.DependentsService;
import com.varaisys.intranet.utils.DependentsForm;

/**
 *
 * @author Kanishka Rajput
 * @Created on 6/feb/2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class DependentsController {
    @Autowired
    DependentsService dependentsService;

    @RequestMapping(value = "/AddDependents", method = RequestMethod.POST)
    public ResponseEntity<?> adduser(@RequestBody DependentsForm dependentsForm) {
        Map<Object, Object> map = new HashMap<>();
        System.out.println("kanishkaaaa----");
        System.out.println(dependentsForm + "++++++++++++++++kanishkaaa");
        if (dependentsForm == null) {
            map.put("Message", "Please provide the details");
        }
        if (dependentsForm != null) {
            System.out.println("form not null");
            boolean f = dependentsService.AddDependents(dependentsForm);
            if (f) {
                map.put("message", dependentsForm);
            }
        }
        return ResponseEntity.ok().body(map);
    }

    @RequestMapping(value = "/getDependents", method = RequestMethod.GET)
    public ResponseEntity<?> getDependents() throws PersonNotFoundException {
        Map<String, Object> map = new HashMap<>();
        // List<Dependents> dependents = dependentsService.getDependents();
        List<Dependents> dependents = dependentsService.getDependents();

        if (dependents == null) {
            map.put("dependents", "No Details Present");
        } else {
            map.put("dependents", dependents);
        }
        return ResponseEntity.ok().body(map);

    }

}

