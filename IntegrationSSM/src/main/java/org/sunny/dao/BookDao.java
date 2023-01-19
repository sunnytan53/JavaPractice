package org.sunny.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sunny.domain.Book;

import java.util.List;

public interface BookDao {
    @Insert("INSERT INTO book (name,type) VALUES (#{name},#{type})")
    public void save(Book book);
    @Update("UPDATE book SET name=#{name},type=#{type} WHERE id=#{id}}")
    public void update(Book book);
    @Delete("DELETE FROM book WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT id,name,type FROM book WHERE id=#{id}")
    public Book getById(Integer id);
    @Select("SELECT id,name,type FROM book")
    public List<Book> getAll();
}
