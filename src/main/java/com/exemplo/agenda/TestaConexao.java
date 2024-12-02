package com.exemplo.agenda;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestaConexao {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3308/agenda";
        String user = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
