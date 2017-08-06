package com.caioguedes.blog.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:development.sqlite");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
