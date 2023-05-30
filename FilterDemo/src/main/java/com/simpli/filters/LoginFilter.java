package com.simpli.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		// Business logic
		String userId = request.getParameter("userid");

		if (userId != null)
			chain.doFilter(request, response);

		else
			out.println("Userid not present. So request is blocked!");

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

	}

}