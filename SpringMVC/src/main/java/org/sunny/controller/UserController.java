package org.sunny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/save")  // set the request location
    @ResponseBody  // set response type
    public String save() {
        System.out.println("request from /save");
        return "{'springmvc':'save'}";
    }
}
