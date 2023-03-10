package org.sunny.controller;

import org.springframework.web.bind.annotation.*;
import org.sunny.domain.User;

// @Controller
// @ResponseBody
@RestController // combine above two
@RequestMapping("/users")
public class UserController {
    // POST -> adding new data
    // PUT  -> updating existed data
    // GET  -> getting existed data
    // @PathVariable is used to capture non-sensitive data in url
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String save(@RequestBody User user) {
        return "saving/adding " + user;
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody User user) {
        return "updating " + user;
    }

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getAll() {
        return "getting all users";
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String get(@PathVariable Integer id) {
        return "getting user with id=" + id;
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return "deleting user with id=" + id;
    }
}
