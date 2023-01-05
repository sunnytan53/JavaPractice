package org.sunny.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.sunny.dao.Book;

// @Component
@Service  // business layer
public class BookService implements BookServiceInterface {
    private Book bookDao;

    public void setBookDao(Book bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("* service save *");
        bookDao.save();
    }
}
