package com.simpli;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/statement-demo")

public class JDBCStatementDemo extends HttpServlet {

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

			// STEP 3 Create the Statement object.

			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery("SELECT * FROM eproduct");

			out.println("<h3> Query Results:</h3>");

			while (rs.next()) {

				int ID = rs.getInt("ID");

				String name = rs.getString("name");

				float price = rs.getFloat("price");

				String date_added = rs.getString("date_added");

				out.println(ID + ", " + name + ", " + price + ", " + date_added + "<br>");

			}

			//dbutil.closeConnection();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		// Insert new row demo

				try {

					// STEP 3 Create the Statement object.

					Statement stmt = connection.createStatement();

		 

					int count = stmt.executeUpdate("INSERT INTO eproduct(name,price) values('HP Camera', 1000);");

		 

					out.println("Sucessfully added " + count + " row ");

		 

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