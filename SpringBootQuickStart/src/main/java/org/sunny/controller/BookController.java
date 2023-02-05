package org.sunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunny.domain.Server;

@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private Environment env;
    @Autowired
    private Server server;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return "input id=" + id;
    }

    @GetMapping("/port")
    public String getPort() {
        return "current port=" + port +
                "\nenv port=" + env.getProperty("server.port") +
                "\nobj port=" + server.getPort();
    }
}
