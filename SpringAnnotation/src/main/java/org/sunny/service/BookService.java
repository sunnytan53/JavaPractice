package org.sunny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.sunny.dao.Book;
import org.sunny.dao.BookInterface;

// @Component
@Service  // business layer
public class BookService implements BookServiceInterface {
    @Autowired
    @Qualifier("BookDaoBean2")  // required if there are no unique class
    // for example this is an interface, and multiple classes can be matched
    private BookInterface bookDao;
    @Value("${example.name}")  // use external property file, still using ${}
    private String name;

    // setter can be ignored if autowire is enabled
    public void setBookDao(Book bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("* service save * name=" + name);
        bookDao.save();
    }
}
