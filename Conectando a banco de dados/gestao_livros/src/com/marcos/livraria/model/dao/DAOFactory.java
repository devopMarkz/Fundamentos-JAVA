package com.marcos.livraria.model.dao;

import com.marcos.livraria.model.dao.implementation.AutorDAOJDBC;
import com.marcos.livraria.model.dao.implementation.BookDAOJDBC;
import com.marcos.livraria.util.db.DB;

public class DAOFactory {

    public static AutorDAO createAutorDAO() {
        return new AutorDAOJDBC(DB.getConnection());
    }

    public static BookDAO createBookDAO() {
        return new BookDAOJDBC(DB.getConnection());
    }

}
