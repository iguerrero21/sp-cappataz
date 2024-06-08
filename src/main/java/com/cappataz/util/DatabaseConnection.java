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

                // // Añadir configuración para UTF-8 en la URL de conexión
                // if (url != null && !url.contains("useUnicode")) {
                //     url += "?useUnicode=true&characterEncoding=utf8mb4";
                // } else {
                //     url += "&useUnicode=true&characterEncoding=utf8mb4";
                // }

                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
