package com.simpli;

import java.io.*;

import java.sql.*;

import java.util.*;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

@WebServlet("/callable-statement-demo")

public class JDBCStoredProcedureDemo extends HttpServlet {

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

		// STEP 3 Create the Statement object.

		try {

			// STEP 3 Create the Prepared Statement object.

			CallableStatement callableStmt = connection.prepareCall("{call add_product(?, ?)}");

			callableStmt.setString(1, "Mac PC");

			callableStmt.setFloat(2, 50000.25f);

			callableStmt.execute();

			out.println("Stored procedure has been executed.<Br>");

			callableStmt.close();

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