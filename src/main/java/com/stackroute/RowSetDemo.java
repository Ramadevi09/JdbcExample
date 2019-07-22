package com.stackroute;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
       public void rowsetDemoExample(){
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
try {
    //Creating and Executing RowSet
    JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
    rowSet.setUrl("jdbc:mysql://localhost:3306/sys");
    rowSet.setUsername("root");
    rowSet.setPassword("Root@123");

    rowSet.setCommand("select * from employee");
    rowSet.execute();

    while (rowSet.next()) {
        // Generating cursor Moved event
        System.out.println("Id: " + rowSet.getInt(1));
        System.out.println("Name: " + rowSet.getString(2));
        System.out.println("age: " + rowSet.getInt(3));
        System.out.println("gender: "+rowSet.getString(4 ));
    }
} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception ex) {
    ex.printStackTrace();
}

}
}
