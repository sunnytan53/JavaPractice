package org.sunny.config;

import org.springframework.context.annotation.Bean;
import org.sunny.dao.Book;


public class AnotherConfig {
    @Bean("thirdPartyBean")  // assume using a 3rd-party bean
    public Book anyName() {
        return new Book();
    }
}
