package com.varaisys.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.varaisys.intranet.service.ContactDeatilsService;
import com.varaisys.intranet.serviceImpl.ContactDetailsServiceImpl;
import com.varaisys.intranet.utils.ContactDetailsForm;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;

import antlr.collections.List;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kanishka Rajput
 * @Created on 31/jan/2023
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class ContactDetailesController {
    @Autowired
    private ContactDeatilsService contactDetailService;

    @RequestMapping(value = "/AddContact", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody ContactDetailsForm contactDetailsForm) {

        Map<Object, Object> map = new HashMap<>();
        System.out.println("kanishkaaaa----");
        System.out.println(contactDetailsForm + "++++++++++++++++++");
        if (contactDetailsForm == null) {
            map.put("Message", "Please provide the details");
        }
        if (contactDetailsForm != null) {
            System.out.println("form not null");
            boolean f = contactDetailService.AddContact(contactDetailsForm);
            if (f) {
                map.put("message", contactDetailsForm);
            }
        }
        return ResponseEntity.ok().body(map);
    }
    // @RequestMapping(value = "/getContactDetails", method = RequestMethod.GET)
    // public String getMethodName() {
    // return "hello get api ";
    // }
}
