package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println("Session Created. listner will be invoked");
		session.setAttribute("username", "Tom");
		session.setAttribute("password", "Jerry");
		System.out.println("Session attribute displayed. listner to come here");
		session.setAttribute("username", "Jim");
		System.out.println("Attribute modified. listner will be invoked");
		session.invalidate();
		System.out.println("Session Destroyed");
	}

}
