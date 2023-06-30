package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import com.varaisys.intranet.model.EmergencyContact;
import com.varaisys.intranet.service.EmergencyContactService;
import com.varaisys.intranet.utils.EmergencyContactForm;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

/**
 *
 * @author Kanishka Rajput
 * @Created on 3/feb/2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class EmergencyContactController {
    @Autowired
    private EmergencyContactService emergencyContactService;

    @RequestMapping(value = "/AddEmergencyContact", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody EmergencyContactForm emergencyContactForm) {

        Map<Object, Object> map = new HashMap<>();
        System.out.println("kanishkaaaa----");
        System.out.println(emergencyContactForm + "++++++++++++++++kanishkaaa");
        if (emergencyContactForm == null) {
            map.put("Message", "Please provide the details");
        }
        if (emergencyContactForm != null) {
            System.out.println("form not null");
            boolean f = emergencyContactService.AddEmergencyContact(emergencyContactForm);
            if (f) {
                map.put("message", emergencyContactForm);
            }
        }
        return ResponseEntity.ok().body(map);
    }

    @RequestMapping(value = "/getPersonContact", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonalContacts() throws PersonNotFoundException {
        Map<String, Object> map = new HashMap<>();
        List<EmergencyContact> emergencyContact = emergencyContactService.getPersonalContacts();
        // System.out.println(getPersonalContacts + ",..kanishkaa");

        if (emergencyContact == null) {
            map.put("emergencycontact", "No Details Present");
        } else {
            map.put("emergencycontact", emergencyContact);
        }
        return ResponseEntity.ok().body(map);

    }

    @RequestMapping(value = "getPersonContact/{Id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonalContact(@PathVariable int Id) throws PersonNotFoundException {
        Map<String, Object> map = new HashMap<>();
        if (Id == 0) {

            throw new PersonNotFoundException();

        } else {
            EmergencyContact emergencyContact = emergencyContactService.getPersonalContact(Id);
            if (emergencyContact == null) {
                map.put("message", "Details are  not Available");
                return ResponseEntity.ok().body(map);
            }
            map.put("details", emergencyContact);
        }
        return ResponseEntity.ok().body(map);
    }

}

