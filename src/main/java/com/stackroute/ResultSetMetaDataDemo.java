package com.stackroute;

import java.sql.*;

public class ResultSetMetaDataDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root@123";
    private static final String SQL = "SELECT * FROM employee";
//retriving details of resultsetmetadata
    public void getResultsetMetaData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        try {
            //establishing connections
            conn = DriverManager.getConnection(URL,
                    USERNAME, PASSWORD);
            //create statement
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
            rsmd = rs.getMetaData();
//retriving resultsetMetadata
            if (rsmd != null) {
                int cols = rsmd.getColumnCount();
                System.out.println("Number of Columns: " + cols);
                System.out.println("Table Name: " +
                        rsmd.getTableName(1));
                System.out.println("Catalog Name: " +
                        rsmd.getCatalogName(1));
                System.out.println
                        ("------------------------------------------");
                for (int i = 1; i <= cols; i++) {
                    System.out.println("Class Name: " +
                            rsmd.getColumnClassName(i));
                    System.out.println("Column Name: " +
                            rsmd.getColumnName(i));
                    System.out.println("Column Type Name: " +
                            rsmd.getColumnTypeName(i));
                    System.out.println
                            ("--------------------------------------");
                }
            } else {
                System.out.println("ResultSetMetadata not supported");
            }

        } catch (SQLException ex1) {
            System.err.println(ex1);
        } finally {
            try {
                stmt.close();
                rs.close();
                conn.close();
            } catch (SQLException ex2) {

            }
        }
    }
}
