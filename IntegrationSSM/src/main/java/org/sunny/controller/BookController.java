package org.sunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sunny.domain.Book;
import org.sunny.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(Book book) {
        boolean save = bookService.save(book);
        return new Result(save, save ? ResultCode.SAVE_OK : ResultCode.SAVE_ERR);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean update = bookService.update(book);
        return new Result(update, update ? ResultCode.UPDATE_OK : ResultCode.UPDATE_ERR);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean delete = bookService.delete(id);
        return new Result(delete, delete ? ResultCode.DELETE_OK : ResultCode.DELETE_ERR);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        ResultCode code = (book != null) ? ResultCode.GET_OK : ResultCode.GET_ERR;
        String msg = (book != null) ? "" : "error in single search query";
        return new Result(book, code, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> list = bookService.getAll();
        ResultCode code = (list != null) ? ResultCode.GET_OK : ResultCode.GET_ERR;
        String msg = (list != null) ? "" : "error in all search query";
        return new Result(list, code, msg);
    }
}
