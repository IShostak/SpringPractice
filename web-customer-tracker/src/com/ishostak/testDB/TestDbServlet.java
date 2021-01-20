package com.ishostak.testDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //setup connection variables
        String user = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to DB: " + jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            out.println("Success");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}
