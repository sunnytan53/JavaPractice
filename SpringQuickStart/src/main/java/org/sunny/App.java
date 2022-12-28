package org.sunny;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sunny.service.BookService;

public class App {
    public static void main(String[] args) {
        // get IoC container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // get bean(s)
        // Book bookDao = (Book) ctx.getBean("bookDaoBean");
        // bookDao.save();
        BookService bookService = (BookService) ctx.getBean("bookServiceBean");
        bookService.save();
    }
}
