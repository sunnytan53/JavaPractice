package org.sunny.service;

import org.sunny.domain.Book;

import java.util.List;

public interface BookServiceInterface {
    public boolean save(Book book);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public Book getById(Integer id);

    public List<Book> getAll();
}
