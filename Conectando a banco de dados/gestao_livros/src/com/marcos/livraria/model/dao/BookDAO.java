package com.marcos.livraria.model.dao;

import com.marcos.livraria.model.entities.Book;

import java.util.List;

public interface BookDAO {

    void insert(Book book);

    void update(Book book);

    void deleteById(int id);

    Book findById(int id);

    List<Book> findAll();

}
