package org.itstep.myWebApp.web.mvc;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 13.03.2017.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("userList", service.getAll());
        return "userList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("user", new User());
        return "editUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(HttpServletRequest req, Model model){
        model.addAttribute("user", service.getById(getId(req)));
        return "editUser";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest req){
        service.delete(getId(req));
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(HttpServletRequest req){

        Integer id = getId(req);

        User user = id == -1 ? new User() : service.getById(id);

        user.setName(req.getParameter("name"));
        user.setLastname(req.getParameter("lastname"));
        user.setCity(req.getParameter("city"));
        user.setEmail(req.getParameter("email"));

        service.save(user);

        return "redirect:/users";
    }

    private int getId(HttpServletRequest req){
        String idS = req.getParameter("id");
        Integer id = idS.isEmpty()? -1: Integer.valueOf(idS);
        return id;
    }

}
