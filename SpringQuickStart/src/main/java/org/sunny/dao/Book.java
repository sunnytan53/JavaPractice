package org.sunny.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Book implements BookInterface, InitializingBean, DisposableBean {
    private Book() {
        // System.out.println("Spring calls no-arg constructor");
    }

    public void save() {
        System.out.println("* dao save *");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("\tinit book");
    }

    public void destroy() {
        System.out.println("\tdestroy book");
    }
}
