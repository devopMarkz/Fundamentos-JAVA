package com.marcos.livraria.model.dao;

import com.marcos.livraria.model.entities.Autor;

import java.util.List;

public interface AutorDAO {

    void insert(Autor autor);

    void deleteById(int id);

    void update(Autor autor);

    Autor findById(int id);

    List<Autor> findAll();

}
