import model.db.DB;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Seller seller = null;
        Connection connection = DB.getConnection();

        try {
            try (PreparedStatement selectStmt = connection.prepareStatement(
                    "SELECT vendedor.Id, vendedor.Name, vendedor.Email, vendedor.BirthDate, vendedor.BaseSalary, departamento.Id, departamento.Name " +
                            "FROM seller AS vendedor " +
                            "INNER JOIN department AS departamento " +
                            "ON vendedor.DepartmentId = departamento.Id " +
                            "WHERE vendedor.Id = ?"
                    )
            ) {

                System.out.print("Qual seu número de matrícula? ");
                int id = new Scanner(System.in).nextInt();

                selectStmt.setLong(1, id);

                ResultSet rs = selectStmt.executeQuery();

                if (rs.next()){
                    seller = new Seller.Builder()
                            .id(rs.getLong("vendedor.Id"))
                            .name(rs.getString("vendedor.Name"))
                            .email(rs.getString("vendedor.Email"))
                            .birthDate(rs.getTimestamp("vendedor.BirthDate").toLocalDateTime())
                            .baseSalary(rs.getDouble("vendedor.BaseSalary"))
                            .department(new Department(rs.getLong("departamento.Id"), rs.getString("departamento.Name")))
                            .build();
                }

            } catch (SQLException e){
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("O tipo de dado inserido é inválido.");
            }

            try (PreparedStatement updateStmt = connection.prepareStatement(
                    "UPDATE seller " +
                            "SET BaseSalary = ? " +
                            " WHERE Id = ?"
                )
            ){
                if (seller != null) {
                    seller.setBaseSalary(seller.getBaseSalary() * 1.5);
                    updateStmt.setDouble(1, seller.getBaseSalary());
                    updateStmt.setLong(2, seller.getId());
                }

                updateStmt.executeUpdate();

            } catch (SQLException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            DB.closeConnection();
        }

    }
}