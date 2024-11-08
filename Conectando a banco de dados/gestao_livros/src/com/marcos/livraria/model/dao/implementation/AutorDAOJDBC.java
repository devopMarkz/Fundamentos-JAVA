package com.marcos.livraria.model.dao.implementation;

import com.marcos.livraria.exception.DbException;
import com.marcos.livraria.model.dao.AutorDAO;
import com.marcos.livraria.model.entities.Autor;
import com.marcos.livraria.util.db.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAOJDBC implements AutorDAO {

    private Connection connection;

    public AutorDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Autor autor) {
        ResultSet rs = null;
        String consulta = "INSERT INTO autor (Name, Email) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getEmail());
            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0) {
                rs = stmt.getGeneratedKeys();
                if(rs.next()) {
                    autor.setId(rs.getInt(1));
                }
            } else throw new DbException("Autor " + autor + " não inserido.");

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void deleteById(int id) {
        String consulta = "DELETE FROM autor WHERE Id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(consulta)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Autor autor) {
        String consulta = "UPDATE autor SET Name = ?, Email = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setString(1, autor.getName());
            stmt.setString(2, autor.getEmail());
            stmt.setInt(3, autor.getId());
            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected == 0) {
                throw new DbException("Erro ao atualizar dados do " + autor);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Autor findById(int id) {
        ResultSet rs = null;
        String consulta = "SELECT * FROM autor WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(consulta)){
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                return new Autor(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Email")
                );
            } else throw new DbException("Autor de ID " + id + " não existe na base de dados.");

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Autor> findAll() {
        String consulta = "SELECT * FROM autor ORDER BY Id";
        ResultSet rs = null;

        try (PreparedStatement stmt = connection.prepareStatement(consulta)){

            List<Autor> autorList = new ArrayList<>();
            rs = stmt.executeQuery();

            while (rs.next()) {
                autorList.add(
                        new Autor(
                                rs.getInt("Id"),
                                rs.getString("Name"),
                                rs.getString("Email")
                ));
            }

            return autorList;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
        }
    }
}
