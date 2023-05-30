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
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		String userId = request.getParameter("userid");

		if (userId == null) {
			out.println("No UserId was found in hidden form field.<br>");
		} else {
			out.println("UserId obtained from hidden form field:" + userId + "<br>");
		}

		out.println("</body></html>");
	}

}