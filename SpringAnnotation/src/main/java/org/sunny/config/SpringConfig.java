package org.sunny.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  // mark it as a config file (replace applicationContext.xml)
// @ComponentScan("org.sunny")  // scan from this directory
@ComponentScan({"org.sunny.dao", "org.sunny.service"})  // scan all directories
@PropertySource({"example.properties"})  // read external files, NO wildcard
public class SpringConfig {
}
