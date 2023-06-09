package com.simpli;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.*;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

import org.hibernate.*;

import com.ecommerce.*;

@WebServlet("/product-details")

public class ProductDetailsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		// STEP 1: Get a Session (connection) from the Session Factory class

		SessionFactory factory = HibernateUtil.getSessionFactory();

		// STEP 2 Session

		Session session = factory.openSession();

		// STEP 32 execute the HQL commands

		// for now we will only test if the connection is establised with MySQL server.

		List<EProduct> eproducts = session.createQuery("from EProduct").list();

		out.println("<br> Data from the eproduct table<table border=1>");

		out.println(
				"<th> ID <th> NAME <th> PRICE <th> DATE ADDED <th> COLORS <th> Screen Sizes <th> OS  <th> FINANCE OPTIONS </th>   ");

		for (EProduct prod : eproducts) {

			// Display Core properties/details

			out.println("<tr><td>" + prod.getID() + "<td>" + prod.getName() + "<td>" + prod.getPrice() + "<td>"

					+ prod.getDateAdded());

			// Display the available colors

			List<Color> colors = prod.getColors();

			out.println("<td> ");

			for (Color color : colors)

				out.println(color.getName() + " &nbsp;");

			// Display the available screensizes

			Collection<ScreenSizes> screenSizes = prod.getScreenSizes();

			out.println("<td> ");

			for (ScreenSizes sSize : screenSizes)

				out.println(sSize.getSize() + " &nbsp;");

			// Display the available OSes

			Set<OS> OSes = prod.getOs();

			out.println("<td>  ");

			for (OS os : OSes)

				out.println(os.getName() + " &nbsp;");

// Display the available finance options

			Map finances = prod.getFinance();

			out.println("<td>  ");

			if (finances.get("CREDITCARD") != null) {

				Finance f = (Finance) finances.get("CREDITCARD");

				out.println(f.getName() + " &nbsp;");

			}

			if (finances.get("BANK") != null) {

				Finance f = (Finance) finances.get("BANK");

				out.println(f.getName() + " &nbsp;");

			}

		}

		session.close();

		out.println("</body></html>");

	}

}