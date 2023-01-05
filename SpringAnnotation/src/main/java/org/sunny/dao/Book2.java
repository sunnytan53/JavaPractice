package org.sunny.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("BookDaoBean2")
@Scope("prototype")
public class Book2 implements BookInterface {
    public void save() {
        System.out.println("* dao 2 save *");
    }
}
