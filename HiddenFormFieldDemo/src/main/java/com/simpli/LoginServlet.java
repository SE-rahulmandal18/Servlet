package com.simpli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		String userId = request.getParameter("userid");

		// Create the form with hidden feilds
		out.println("<form action='dashboard' method='post'>");
		out.println("<input type='hidden' name='userid' id='userid' value='" + userId + "'>");
		out.println("<input type='submit' value='submit' >");
		out.println("</form>");
		out.println("<script>document.forms[0].submit();</script>");

	}

}