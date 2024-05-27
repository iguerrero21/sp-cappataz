package main.java.com.cappataz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = System.getenv("DB_URL");
                String user = System.getenv("DB_USERNAME");
                String password = System.getenv("DB_PASSWORD");

                if (url == null || user == null || password == null) {
                    throw new SQLException("Database credentials are not set in environment variables.");
                }

                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
