package com.stackroute;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SampleJdbcDemo sampleJdbcDemo=new SampleJdbcDemo();
        //retriving employee details
        sampleJdbcDemo.empDetails();
        //retriving employee details from reverse order
        sampleJdbcDemo.getEmployeeDetailsInReverse();
        //retriving employee detais from second row in reverse order
        sampleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        //display employee details by name and gender
        sampleJdbcDemo.getEmployeeDetailsBYNameAndGender("rama","f");
        System.out.println();
        //database metadatademo
        DatabaseMetaDataDemo databaseMetaDataDemo=new DatabaseMetaDataDemo();
        databaseMetaDataDemo.getDatabaseMetaData();
        System.out.println();
        //ResultsetMetadata demo
        ResultSetMetaDataDemo resultSetMetaDataDemo=new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.getResultsetMetaData();
        System.out.println();
        //jdbc batchDemo
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        jdbcBatchDemo.jdbcBatchDemoExample();
        System.out.println();
        //JdbcTranctionDemo
        JdbcTranctionDemo jdbcTranctionDemo=new JdbcTranctionDemo();
        jdbcTranctionDemo.transcationDemo();
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.rowsetDemoExample();

    }
}
