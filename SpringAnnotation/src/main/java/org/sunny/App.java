package org.sunny;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sunny.dao.Book;
import org.sunny.service.BookService;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book bookDao = (Book) ctx.getBean("bookDaoBean");
        System.out.println(bookDao);
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
