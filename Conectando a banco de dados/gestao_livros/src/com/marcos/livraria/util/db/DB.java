package com.marcos.livraria.util.db;

import com.marcos.livraria.exception.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null) {
            try {
                String url = loadProperties().getProperty("dburl");
                connection = DriverManager.getConnection(url, loadProperties());
                return connection;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        } else return connection;
    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException("Erro ao fechar conexão. Caused by: " + e.getMessage());
            }
        }
    }

    public static void closeStatement(PreparedStatement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new DbException("Erro ao fechar Statsement. " + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException("Erro ao fechar ResultSet. " + e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fr = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fr);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar properties. Caused by: " + e.getMessage());
        }
    }

}
