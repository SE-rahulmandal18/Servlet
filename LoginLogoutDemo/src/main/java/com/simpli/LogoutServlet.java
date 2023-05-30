package com.simpli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate(); // destroy the session and its contents

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Logged out of session.<br>");
		out.println("<a href='login.html' >Login again here</a> <br>");
		out.println("</body></html>");

	}

}
