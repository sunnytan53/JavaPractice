package org.sunny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunny.controller.ResultCode;
import org.sunny.dao.BookDao;
import org.sunny.domain.Book;
import org.sunny.exception.BusinessException;
import org.sunny.exception.SystemException;

import java.util.List;

@Service
@Transactional
public class BookService implements BookServiceInterface {
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        // capture possible exception and throw it as our exception
        if (id <= 0) {
            throw new BusinessException("invalid id, should be > 0!", ResultCode.BUSINESS_ERR);
        }
        try {
            // int i = 1/0;  // simulate a System Exception
            return bookDao.getById(id);
        }
        catch (Exception e) {
            throw new SystemException("server time out, please try again", ResultCode.SYSTEM_TIMEOUT_ERR);
        }
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
