package com.ishostak.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?" +
                "useSSL=false&serverTimezone=UTC";

        String user = "hbstudent";
        String password = "hbstudent";

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("Connection successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
