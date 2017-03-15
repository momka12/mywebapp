package org.itstep.myWebApp.web.rest;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by student on 15.03.2017.
 */

@RestController
@RequestMapping("rest/user/{userId}/mails")
public class RMailController {

    @Autowired
    MailService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Mail>> getAllForUser(@PathVariable Integer userId){
        return new ResponseEntity<List<Mail>>(service.getAll(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mail> getMailById(@PathVariable Integer userId, @PathVariable Integer id){
        return new ResponseEntity<Mail>(service.getById(userId, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mail> deleteMail(@PathVariable Integer userId, @PathVariable Integer id){
        Mail mail = service.getById(userId, id);
        service.delete(userId, id);
        return new ResponseEntity<Mail>(mail, HttpStatus.OK);
    }



}
