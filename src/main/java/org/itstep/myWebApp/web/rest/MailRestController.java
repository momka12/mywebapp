package org.itstep.myWebApp.web.rest;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/rest/users/{userId}/mails")
public class MailRestController {

    @Autowired
    private MailService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Mail> getAll(@PathVariable(value = "userId") Integer userId) {
        return  service.getAll(userId);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Mail getById(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "id") Integer id){
        return service.getById(userId, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "id") Integer id){
        service.delete(userId, id);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "id") Integer id, @RequestBody Mail mail){
        mail.setUserId(userId);
        mail.setId(id);
        service.save(mail);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Mail save(@PathVariable(value = "userId") Integer userId, @RequestBody Mail mail){
        mail.setUserId(userId);
        return service.save(mail);
    }

}
