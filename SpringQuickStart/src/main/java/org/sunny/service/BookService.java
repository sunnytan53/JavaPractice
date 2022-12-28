package org.sunny.service;

import org.sunny.dao.Book;
public class BookService implements BookServiceInterface{
    Book bookDao = new Book();

    public void save() {
        System.out.println("* service save *");
        bookDao.save();
    }
}
