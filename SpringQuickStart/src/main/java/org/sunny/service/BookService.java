package org.sunny.service;

import org.sunny.dao.Book;

public class BookService implements BookServiceInterface {

    // remove new in business layer
    // Book bookDao = new Book();
    Book bookDao;

    public void setBookDao(Book bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("* service save *");
        bookDao.save();
    }
}
