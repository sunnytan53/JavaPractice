package org.sunny;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sunny.config.SpringConfig;
import org.sunny.dao.Book;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Book book = ctx.getBean(Book.class);
        System.out.println(book.getClass());  // it is a proxy
        book.save();
        book.update();
    }
}
