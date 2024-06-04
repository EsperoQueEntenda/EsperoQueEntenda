package com.dogspot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dogspotupx?serverTimezone=America/Sao_Paulo";
    private static final String USER = "bruno";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        try {
            System.out.println("Tentando conectar ao banco de dados: " + URL);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
