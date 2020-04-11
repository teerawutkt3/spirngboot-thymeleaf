package com.tutorial.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/df")
    public ModelAndView df(){
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("home.html");
        return mav;
    }
    @GetMapping("/about")
    public ModelAndView about(){
        ModelAndView mav = new ModelAndView("about.html");
        return mav;
    }

}
