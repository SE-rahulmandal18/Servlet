package com.simpli;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.ecommerce.EProduct;

@WebServlet("/HibernateQueryDemo")

public class HibernateQueryDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		// STEP 1: Get a Session (connection) from the Session Factory class

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		out.println("Hibernate Session opened.<br>");

		// STEP 2 execute the HQL commands

		// for now we will only test if the connection is establised with MySQL server.

		List<EProduct> eproducts = session.createQuery("from EProduct").list();

		out.println("<br> Data from the eproduct table<table border=1>");

		for (EProduct prod : eproducts) {

			out.println("<tr><td>" + prod.getID() + "<td>" + prod.getName() + "<td>"

					+ prod.getPrice() + "<td>" + prod.getDateAdded());

		}

		session.close();

		out.println("Hibernate Session closed.<br>");

		out.println("</body></html>");

	}

}