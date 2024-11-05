package com.empresa.projeto;

import com.empresa.projeto.repository.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)){

            System.out.print("Informe o ID do usuário que deseja deletar do sistema: ");
            int id = sc.nextInt();

            try (Connection connection = DB.getConnection()){
                String consultaDelete = "DELETE FROM seller WHERE Id = ?";

                try (PreparedStatement deleteStmt = connection.prepareStatement(consultaDelete)){

                    deleteStmt.setInt(1, id);
                    deleteStmt.executeUpdate();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            } catch (SQLException e) {
                System.out.println("Erro ao estabelecer conexão com banco de dados.");
            }
        }

    }
}