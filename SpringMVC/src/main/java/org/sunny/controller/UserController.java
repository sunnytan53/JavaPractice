package org.sunny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sunny.domain.User;
import org.sunny.domain.User2;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")  // add pre-location to every request in this class
public class UserController {
    @RequestMapping("/save")  // set the request location
    @ResponseBody  // set response type
    public String save() {
        return "request from /user/save";
    }

    @RequestMapping("/param")
    @ResponseBody
    public String param(String name, Integer age) {
        return "request with param: name=" + name + ", age=" + age;
    }

    @RequestMapping("/paramDifferentName")
    @ResponseBody
    // use @RequestParam to solve
    public String param2(@RequestParam("name") String username, Integer age) {
        return "request with param: username=" + username + ", age=" + age;
    }

    @RequestMapping("/paramClass")
    @ResponseBody
    // if all variables are primitive types, simply just pass them in
    public String param3(User user) {
        return "request with param: " + user;
    }

    @RequestMapping("/paramClassContainsClass")
    @ResponseBody
    // if one or more variables are reference types, use *.* to pass them in
    public String param4(User2 user2) {
        // seems like it requires getter()
        return "request with param: " + user2;
    }

    @RequestMapping("/paramArray")
    @ResponseBody
    // use same key for all values (that match param name)
    public String param5(String[] arr) {
        return "request with param: " + Arrays.toString(arr);
    }

    @RequestMapping("/paramList")
    @ResponseBody
    // since List is still a reference type
    // we need to specify the @RequestParam to make it works
    public String param6(@RequestParam List<String> arr) {
        return "request with param: " + arr;
    }

}
