package org.itstep.myWebApp.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by student on 14.03.2017.
 */

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping
    public String root(){
        return "index";
    }

}
