package com.simpli;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-drop-database-demo")

public class CreateDropDatabaseDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DBUtil dbutil = null;

	@Override

	public void init() throws ServletException {

		super.init();

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");

		Properties props = new Properties();

		try {

			props.load(in);

			dbutil = new DBUtil(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		// Get a DB connection

		Connection connection = dbutil.getConnection();
		try {

			// STEP 3 Create the Statement object.

			Statement stmt = connection.createStatement();
//
//			stmt.execute("CREATE DATABASE SAMPLE1");
//
//			out.println("Created database: SAMPLE1<br>");
//
//			stmt.execute("USE SAMPLE1");
//
//			stmt.execute("CREATE TABLE TABLE1(name varchar(20))");
//
//			out.println("Created TABLE: TABLE1 inside SAMPLE1<br>");

			// delete the table

			stmt.execute("USE SAMPLE1");

			stmt.execute("DROP TABLE TABLE1");

			out.println("Dropped TABLE: TABLE1 from SAMPLE1");

 

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	@Override

	public void destroy() {

		super.destroy();

		try {

			dbutil.closeConnection();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}