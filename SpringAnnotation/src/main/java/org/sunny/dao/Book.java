package org.sunny.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

// @Component("bookDaoBean")  // specify the name of this bean
@Repository("BookDaoBean")  // database layer
@Scope("prototype")
public class Book implements BookInterface {
    public void save() {
        System.out.println("* dao save *");
    }
}
