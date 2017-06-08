package com.golf.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TaskController {
    @RequestMapping("/task")
    
    public String page(){
        return "html/offer";
    }
}
