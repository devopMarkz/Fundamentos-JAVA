package com.marcos.livraria.model.dao.implementation;

import com.marcos.livraria.exception.DbException;
import com.marcos.livraria.model.dao.BookDAO;
import com.marcos.livraria.model.entities.Autor;
import com.marcos.livraria.model.entities.Book;
import com.marcos.livraria.util.db.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAOJDBC implements BookDAO {

    private Connection connection;

    public BookDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Book book) {
        ResultSet rs = null;
        String consulta = "INSERT INTO book (Title, Price, AutorId) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, book.getTitle());
            stmt.setDouble(2, book.getPrice());
            stmt.setInt(3, book.getAutor().getId());
            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0) {
                rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    book.setId(rs.getInt(1));
                }
            } else throw new DbException("Livro " + book + " não inserido.");

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void update(Book book) {
        String consulta = "UPDATE book SET Title = ?, Price = ?, AutorId = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setString(1, book.getTitle());
            stmt.setDouble(2, book.getPrice());
            stmt.setInt(3, book.getAutor().getId());
            stmt.setInt(4, book.getId());
            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected == 0) {
                throw new DbException("Erro ao atualizar dados do " + book);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        String consulta = "DELETE FROM book WHERE Id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(consulta)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Book findById(int id) {
        ResultSet rs = null;
        String consulta = "SELECT book.*, autor.Name, autor.Email FROM book INNER JOIN autor ON book.AutorId = autor.Id WHERE book.Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(consulta)){

            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                Autor autor = instantiateAutor(rs);
                return instantiateBook(rs, autor);
            } else throw new DbException("Livro de ID " + id + " não encontrado.");

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Book> findAll() {
        ResultSet rs = null;
        String consulta = "SELECT book.*, autor.Name, autor.Email FROM book INNER JOIN autor ON book.AutorId = autor.Id";

        try (PreparedStatement stmt = connection.prepareStatement(consulta)){

            List<Book> bookList = new ArrayList<>();
            Map<Integer, Autor> autorMap = new HashMap<>();
            rs = stmt.executeQuery();

            while (rs.next()) {
                Autor autor = autorMap.get(rs.getInt("book.AutorId"));
                if (autor == null) {
                    autor = instantiateAutor(rs);
                    autorMap.put(autor.getId(), autor);
                }
                bookList.add(instantiateBook(rs, autor));
            }

            return bookList;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
        }
    }

    private Book instantiateBook(ResultSet rs, Autor autor) throws SQLException {
        return new Book.Builder()
                .id(rs.getInt("Id"))
                .title(rs.getString("Title"))
                .price(rs.getDouble("Price"))
                .autor(autor)
                .build();
    }

    private Autor instantiateAutor(ResultSet rs) throws SQLException{
        return new Autor(
                rs.getInt("book.AutorId"),
                rs.getString("autor.Name"),
                rs.getString("autor.Email")
        );
    }
}
