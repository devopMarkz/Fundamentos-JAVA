import model.db.DB;
import model.db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Escreva a sua consulta: ");
        String consulta = new Scanner(System.in).nextLine();

        try (Connection connection = DB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(consulta)
        ){

            ResultSet rs = stmt.executeQuery();


            while (rs.next()){
                System.out.println(rs.getInt("Id")
                        + ", " + rs.getString("Name")
                        + ", " + rs.getString("Email")
                        + ", " + rs.getString("BirthDate")
                        + ", " + rs.getDouble("BaseSalary"));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}