package org.sunny.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Book implements BookInterface {
    public void save() {
        System.out.println("* dao save *");
    }

    public void update() {
        System.out.println("* dao update *");
    }
}
