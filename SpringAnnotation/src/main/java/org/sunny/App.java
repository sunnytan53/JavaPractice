package org.sunny;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sunny.config.SpringConfig;
import org.sunny.dao.Book;
import org.sunny.service.BookService;

public class App
{
    public static void main( String[] args )
    {
        // use the annotation config using Java class (no more resource file required)
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Book bookDao = (Book) ctx.getBean("bookDaoBean");
        System.out.println(bookDao);
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
