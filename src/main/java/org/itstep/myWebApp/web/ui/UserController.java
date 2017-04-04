package org.itstep.myWebApp.web.ui;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        return new ModelAndView("userList", "userList", service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getOne(@PathVariable(value = "id") Integer id){
        return new ModelAndView("user", "user", service.getById(id));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        service.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam(value = "id") Integer id){
        return new ModelAndView("editUser", "user", service.getById(id));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(){
        return new ModelAndView("editUser", "user", new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute User user){
        service.save(user);
        return "redirect:/users";
    }


}
