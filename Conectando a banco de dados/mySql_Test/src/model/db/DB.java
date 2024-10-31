package model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null){
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
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fr = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fr);
            return properties;
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
