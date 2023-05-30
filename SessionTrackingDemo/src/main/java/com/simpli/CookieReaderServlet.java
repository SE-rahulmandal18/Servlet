package com.simpli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookieReader")
public class CookieReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// read the cookies coming from the browser request
		Cookie[] cookies = request.getCookies();

		out.println("Found the following cookies:");
		for (Cookie cookie : cookies) {
			out.println("name of cookie " + cookie.getName());
			out.println("value of cookie " + cookie.getValue());
			out.println();
		}
	}

}