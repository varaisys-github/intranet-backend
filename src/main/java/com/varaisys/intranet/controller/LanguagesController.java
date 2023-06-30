package com.varaisys.intranet.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.varaisys.intranet.service.LanguagesService;
import com.varaisys.intranet.utils.LanguagesForm;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;
import com.varaisys.intranet.model.languagesDetails;
import java.util.List;


/**
 *
 * @author Kanishka Rajput
 * @Created on 20/mar/2023
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class LanguagesController {
    @Autowired
    LanguagesService languagesService;


    @RequestMapping(value = "/Addlanguages", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody LanguagesForm languagesForm) {

        Map<Object, Object> map = new HashMap<>();
        System.out.println("kanishkaaaa----");
        System.out.println(languagesForm + "++++++++++++++++kanishkaaa");
        if (languagesForm == null) {
            map.put("Message", "Please provide the details");
        }
        if (languagesForm != null) {
            System.out.println("form not null");
            boolean f = languagesService.Addlanguages(languagesForm);
            if (f) {
                map.put("message", languagesForm);
            }
        }
        return ResponseEntity.ok().body(map);
    }

    @RequestMapping(value = "/getlanguages", method = RequestMethod.GET)
    public ResponseEntity<?> getLanguages() throws PersonNotFoundException {
        Map<String, Object> map = new HashMap<>();
        List<languagesDetails> languagesDetails = languagesService.getlanguages();
        // System.out.println(getPersonalContacts + ",..kanishkaa");

        if (languagesDetails == null) {
            map.put("languagesDetails", "No Details Present");
        } else {
            map.put("languagesDetails",languagesDetails);
        }
        return ResponseEntity.ok().body(map);

    }


    
}
