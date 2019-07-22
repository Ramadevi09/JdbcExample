package com.stackroute;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/sys";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root@123";

    public void getDatabaseMetaData() {
        Connection conn = null;
        DatabaseMetaData dbmd = null;
        try {
            //establish connection
            conn = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
            //retriving database metaData
            dbmd = conn.getMetaData();
            if (dbmd != null) {
                System.out.println("Database Version: " +
                        dbmd.getDatabaseProductVersion());
                System.out.println("Driver Name: " +
                        dbmd.getDriverName());
                System.out.println("Driver Version: " +
                        dbmd.getDriverVersion());
                System.out.println("URL: " +
                        dbmd.getURL());
                System.out.println("User Name: " +
                        dbmd.getUserName());
                System.out.println(
                        (dbmd.supportsTransactions() ?
                                "Transaction supported." :
                                "Transaction not supported."));
            } else {
                System.out.println("Metadata not supported");
            }
        } catch (SQLException ex1) {
            System.err.println(ex1);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex2) {

            }
        }
    }
}

