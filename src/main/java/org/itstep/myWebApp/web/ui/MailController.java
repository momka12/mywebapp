package org.itstep.myWebApp.web.ui;


import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "users/{userId}/mails")
public class MailController {

    @Autowired
    private MailService service;

    @GetMapping()
    public ModelAndView getAll(@PathVariable(value = "userId") Integer userId) {
        return  new ModelAndView("mailList", "mails",  service.getAll(userId));
    }

//    @GetMapping()
//    public Mail getById(@PathVariable(value = "userId") Integer userId, @RequestParam(value = "id") Integer id){
//        return service.getById(userId, id);
//    }

    @GetMapping(value = "/delete")
    public String delete(@PathVariable(value = "userId") Integer userId, @RequestParam(value = "id") Integer id){
        service.delete(userId, id);
        return ("redirect:/users/" + userId + "/mails");
    }

    @GetMapping(value = "/update")
    public ModelAndView update(@PathVariable(value = "userId") Integer userId, @RequestParam(value = "id") Integer id){
//        mail.setUserId(userId);
//        mail.setId(id);
//        service.save(mail);
        return new ModelAndView("editMail", "mail", service.getById(userId, id));
    }

    @GetMapping(value = "/create")
    public ModelAndView create(){
        return new ModelAndView("editMail", "mail", new Mail());
    }

    @PostMapping()
    public String save(@PathVariable(value = "userId") Integer userId, @ModelAttribute Mail mail){
        mail.setUserId(userId);
        service.save(mail);
        return ("redirect:/users/" + userId + "/mails");
    }

}
