package com.simpli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		HttpSession session = request.getSession(false);

		if (session == null) {
			out.println("No http session object found");
		}
else {
			String userId = (String) session.getAttribute("userid");

			if (userId != null) {
				out.println("UserId obtained from session :" + userId + "<br>");
				out.println("<a href='logout'>Logout of session</a><br>");

			} else {
				out.println("UserId not found in the  session  object. <br>");
			
			}
			
			
			
}}}