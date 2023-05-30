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
		
		String userId = request.getParameter("userid");

		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("userid", userId);	
		
		PrintWriter out = response.getWriter();
		out.println("<html>Http Session object has been created."
				+ " You can go to the dashboard<a href='dashboard'>Dashboard </a> and check your userid is there</html>");		
	}

}