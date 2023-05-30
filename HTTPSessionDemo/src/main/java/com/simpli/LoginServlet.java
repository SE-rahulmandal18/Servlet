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

		// Create the HTTP session
		// and add the user id into it
		HttpSession session = request.getSession(true);
		//getSession(true) means if a session already (someother servlet has created)
		// then use that session object. Otherwise create a new empty session object.
		
		session.setAttribute("userid", userId);	
		
		PrintWriter out = response.getWriter();
		out.println("Http Session object has been created."
				+ " You can go to the dashboard and check your userid is there");		
	}

}