package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {

    private static final String URL = "jdbc:mysql://localhost:3306/Petshop";
    private static final String USER = "Samir";
    private static final String PASSWORD = "petshop";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Verifique se o driver MySQL está no classpath
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado.", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
