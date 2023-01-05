package org.sunny;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sunny.config.SpringConfig;
import org.sunny.dao.Book;
import org.sunny.service.BookService;

public class App {
    public static void main(String[] args) {
        // use the annotation config using Java class (no more resource file required)
        // ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ctx.registerShutdownHook();

        BookService bookService = ctx.getBean(BookService.class);
        BookService bookService2 = ctx.getBean(BookService.class);
        System.out.print("scope = singleton -> same object = ");
        System.out.println(bookService == bookService2);

        Book book = (Book) ctx.getBean("BookDaoBean");
        Book book2 = (Book) ctx.getBean("BookDaoBean");
        System.out.print("scope = prototype -> same object = ");
        System.out.println(book == book2);

        bookService.save();

        System.out.println(ctx.getBean("thirdPartyBean"));
    }
}
