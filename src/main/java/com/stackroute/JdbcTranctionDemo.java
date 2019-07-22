package com.stackroute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTranctionDemo {
    public void transcationDemo() {
        try {
            //loading mysql driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }//establish connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
            //prepared statement
             PreparedStatement ps = connection.prepareStatement("insert into employee values(?,?,?,?)"))   {
            connection.setAutoCommit(false);
           // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner=new Scanner(System.in);
            while (true) {

                System.out.println("enter id");
                String s1 =scanner.next();
                int id = Integer.parseInt(s1);

                System.out.println("enter name");
                String name = scanner.next();

                System.out.println("enter age");
                int age = scanner.nextInt();
                System.out.println("enter gender");
                String gender = scanner.next();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4,gender);
                ps.executeUpdate();


                System.out.println("commit/rollback");
                String answer = scanner.next();
                if (answer.equals("commit")) {
                    connection.commit();
                }
                if (answer.equals("rollback")) {
                    connection.rollback();
                }
                System.out.println("Want to add more records y/n");
                String ans = scanner.next();
                if (ans.equals("n")) {
                    break;
                }

            }
            connection.commit();
            System.out.println("record successfully saved");
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
