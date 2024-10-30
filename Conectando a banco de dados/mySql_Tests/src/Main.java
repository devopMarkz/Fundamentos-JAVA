import model.db.DB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DB.getConnection();
        System.out.print(connection);
        DB.closeConnection();

    }
}