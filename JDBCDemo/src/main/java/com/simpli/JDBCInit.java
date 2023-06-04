package com.simpli;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/init")

public class JDBCInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// STEP 1 LOAD THE JDBC DRIVER

			Class.forName("com.mysql.jdbc.Driver");

			// STEP 2 GET THE CONNECTION TO THE DATABSE

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "userid",
					"password");

			PrintWriter out = response.getWriter();
			out.println("SUCCESS!");

		} catch (ClassNotFoundException | SQLException e) {

		}

	}

}
