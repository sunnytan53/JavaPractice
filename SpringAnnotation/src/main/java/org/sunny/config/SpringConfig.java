package org.sunny.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // mark it as a config file (replace applicationContext.xml)
// @ComponentScan("org.sunny")  // scan from this directory
@ComponentScan({"org.sunny.dao", "org.sunny.service"})  // scan all directories
public class SpringConfig {
}
