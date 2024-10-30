package model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            String url = loadProperties().getProperty("dburl");
            connection = DriverManager.getConnection(url, loadProperties());
            return connection;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(){
        try {
            if(connection != null) connection.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")){

            Properties props = new Properties();
            props.load(fs);

            return props;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
