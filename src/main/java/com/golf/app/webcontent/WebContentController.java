package com.golf.app.webcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebContentController {
    @RequestMapping("/ini")
    public String page(){
        return "html/homepage";
    }
    
    @RequestMapping("/ini2")
    public String page2(){
        return "html/homepage";
    }
    
}
