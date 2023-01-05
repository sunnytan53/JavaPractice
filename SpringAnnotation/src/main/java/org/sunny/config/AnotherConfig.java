package org.sunny.config;

import org.springframework.context.annotation.Bean;
import org.sunny.dao.Book;


public class AnotherConfig {
    @Bean("thirdPartyBean")  // assume using a 3rd-party bean
    public Integer[] anyName() {
        return new Integer[]{};
    }

    // it will use autowire to find used bean
    @Bean("thirdPartyBeanWithBeanInjection")
    public String[] anyName2(Book book) {
        System.out.println("* getting autowired bean *");
        return new String[]{};
    }
}
