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
        return new Result(save ? ResultCode.SAVE_OK : ResultCode.SAVE_ERR, save);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean update = bookService.update(book);
        return new Result(update ? ResultCode.UPDATE_OK : ResultCode.UPDATE_ERR, update);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean delete = bookService.delete(id);
        return new Result(delete ? ResultCode.DELETE_OK : ResultCode.DELETE_ERR, delete);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        ResultCode code = (book != null) ? ResultCode.GET_OK : ResultCode.GET_ERR;
        String msg = (book != null) ? "" : "单条查询操作出现错误";
        return new Result(code, book, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> list = bookService.getAll();
        ResultCode code = (list != null) ? ResultCode.GET_OK : ResultCode.GET_ERR;
        String msg = (list != null) ? "" : "全部查询操作出现错误";
        return new Result(code, list, msg);
    }
}
