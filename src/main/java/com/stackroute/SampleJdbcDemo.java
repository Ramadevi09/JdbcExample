package com.stackroute;

import java.sql.*;

public class SampleJdbcDemo {
    private Connection connection;
    Statement statement;
    ResultSet resultSet;

    public void empDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println("name is " + resultSet.getString(2) + " " + "age is " + resultSet.getInt(3) + " gender is " + "" + resultSet.getString(4));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    public void getEmployeeDetailsBYNameAndGender(String name, String gender) {
        String name1=null;
        String gender1=null;
        name1=name;
        gender1=gender;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee where employeeName='"+name+"' and gender='"+gender+"'" )) {
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2) + "age is " + resultSet.getInt(3) + "gender is " + resultSet.getString(4));
            }
        }
            catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public void getEmployeeDetailsInReverse () {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("Select * from employee")) {


                resultSet.afterLast();
                while (resultSet.previous()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }

        public void getEmployeeDetailsFromSecondRowInReverse () {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Root@123");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("Select * from employee")) {
                resultSet.absolute(3);
                //resultSet.afterLast();
                while (resultSet.previous()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+ "gender is :"+ resultSet.getString(3));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }

