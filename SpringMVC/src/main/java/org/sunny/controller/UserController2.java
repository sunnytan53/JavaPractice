package org.sunny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sunny.domain.User;
import org.sunny.domain.User2;

import java.util.List;

@Controller
@RequestMapping("/user")
// have to enable web mvc in config
public class UserController2 {
    @RequestMapping("/paramJsonList")
    @ResponseBody
    // json data is not in param, it is in body
    public String param(@RequestBody List<String> arr) {
        return "request with param: " + arr;
    }

    @RequestMapping("/paramJsonClass")
    @ResponseBody
    public String param2(@RequestBody User user) {
        // the json data should have the name as key
        return "request with param: " + user;
    }

    @RequestMapping("/paramJsonClassContainsClass")
    @ResponseBody
    public String param3(@RequestBody User2 user) {
        // simply use nested json to represent inner classes
        return "request with param: " + user;
    }
}
