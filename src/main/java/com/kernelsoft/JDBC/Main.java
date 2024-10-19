package com.kernelsoft.JDBC;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");


        Statement stmt = conn.createStatement(); // Prepared Statements (Parameterized Queries)
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees WHERE department = ?");

        pstmt.setInt(1, 1);


        // calling a stored procedure
        String preparedSql = "{call insertEmployee(?,?,?,?)}";
        try (CallableStatement cstmt = conn.prepareCall(preparedSql)) {
            cstmt.setString(2, "ana");
            cstmt.registerOutParameter(1, Types.INTEGER);
        }

        String selectSql = "SELECT * FROM employees";
        try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee emp = new Employee();
                emp.setId(resultSet.getInt("emp_id"));
                emp.setName(resultSet.getString("name"));
                emp.setPosition(resultSet.getString("position"));
                emp.setSalary(resultSet.getDouble("salary"));
                Blob blob = resultSet.getBlob("profile_picture");
                InputStream in = blob.getBinaryStream();

                employees.add(emp);
            }
        }

        // get general information about the database
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet tablesResultSet = dbmd.getTables(null, null, "%", null);
        while (tablesResultSet.next()) {
            System.out.println(tablesResultSet.getString("TABLE_NAME"));
        }



        // batch insert in JDBC
        PreparedStatement ps = conn.prepareStatement("INSERT INTO employees VALUES (?, ?)");

        ps.setString(1, "John");
        ps.setString(2,"Doe");
        ps.addBatch();

        ps.clearParameters();
        ps.setString(1, "Dave");
        ps.setString(2,"Smith");
        ps.addBatch();

        int[] results = ps.executeBatch();

    }
}
