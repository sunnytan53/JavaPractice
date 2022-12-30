package org.sunny.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.sunny.dao.Book;

public class BookService implements BookServiceInterface, InitializingBean, DisposableBean {

    // remove new in business layer
    // Book bookDao = new Book();
    private Book bookDao;

    public void setBookDao(Book bookDao) {
        System.out.println("\tset BookDao");
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("* service save *");
        bookDao.save();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("\tinit service");
    }

    public void destroy() {
        System.out.println("\tdestroy service");
    }
}
