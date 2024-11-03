import model.db.DB;
import model.db.DbException;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Connection connection = DB.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES \n" +
                "  (?, ?, ?, ?, ?)")
        ){

            Seller seller = new Seller.Builder()
                    .name("Marcos")
                    .email("marcos@gmail.com")
                    .birthDate(LocalDateTime.parse("2002-09-25 00:00:00", fmt))
                    .baseSalary(2060.00)
                    .department(new Department(2L, "Computers"))
                    .build();

            stmt.setString(1, seller.getName());
            stmt.setString(2, seller.getEmail());
            stmt.setTimestamp(3, Timestamp.valueOf(seller.getBirthDate()));
            stmt.setDouble(4, seller.getBaseSalary());
            stmt.setLong(5, seller.getDepartment().getId());
            stmt.addBatch();

            stmt.executeBatch();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}