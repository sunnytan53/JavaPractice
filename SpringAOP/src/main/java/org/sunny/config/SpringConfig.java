package org.sunny.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.sunny")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
