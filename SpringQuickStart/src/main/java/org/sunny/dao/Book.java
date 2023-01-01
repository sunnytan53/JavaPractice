package org.sunny.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.*;

public class Book implements BookInterface, InitializingBean, DisposableBean {
    private int[] array;
    private List<Integer> list;
    private Set<Integer> set;
    private Map<String, String> map;
    private Properties properties;


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

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Book{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
