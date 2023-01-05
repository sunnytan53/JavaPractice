package org.sunny.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component("bookDaoBean")  // specify the name of this bean
@Repository("bookDaoBean")  // database layer
public class Book implements BookInterface {
    public void save() {
        System.out.println("* dao save *");
    }
}
