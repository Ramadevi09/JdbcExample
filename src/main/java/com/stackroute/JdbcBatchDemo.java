package com.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchDemo {
    public void jdbcBatchDemoExample() {
        try {
            //loading mysql driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                //establish connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
               //create statement
                Statement statement = connection.createStatement()) {
            //add queries into batch
            statement.addBatch("insert into employee values(12,'sindhu',23,'m')");
            statement.addBatch("insert into employee values(12,'bhargavi',23,'f')");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}