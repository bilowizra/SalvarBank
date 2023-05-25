package com.bankapplication.salvarbank.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver {

    private Connection conn;

    public DatabaseDriver() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:SalvarBank.db");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
