package org.sunny;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.sunny.dao.Book;
import org.sunny.service.BookService;

public class App {
    public static void main(String[] args) {
        // get IoC container
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // tell the container to destroy beans after JVM closes
        // NOTE: prototype objects doesn't call destroy() to avoid memory leak
        ctx.registerShutdownHook();

        // get bean(s)
        BookService bookService = (BookService) ctx.getBean("bookServiceBean");
        bookService.save();
        // use alternative name
        BookService bookService2 = (BookService) ctx.getBean("altBookService");
        bookService2.save();

        System.out.print("scope = singleton -> same object = ");
        System.out.println(bookService == bookService2);

        // if there is no no-arg constructor, it will generate an error
        Book book = (Book) ctx.getBean("bookDaoBean");
        Book book2 = (Book) ctx.getBean("bookDaoBean");
        System.out.print("scope = prototype -> same object = ");
        System.out.println(book == book2);

        // check collection injection
        System.out.println(book);

        // NOT recommended because it is forced to close everything
        // ctx.close();
    }
}
