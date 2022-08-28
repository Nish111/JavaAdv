package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class FirstServlet
 */
public class SecondSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//User u = new User();
		HttpSession session = request.getSession(false);// to not create new session but continue with the same session
		// started by first servlet, reference to same session started in first step of wizard when one.html posted to the 
		// first servlet
		// we will check if session is not null so that active session exists and then use it
		if(session != null) {
			User u = (User) session.getAttribute("user");
			u.setEmail(request.getParameter("email"));
			u.setAge(Integer.parseInt(request.getParameter("age"))); // convert from String to int
			session.setAttribute("user", u);
			response.sendRedirect("third.html");
		}
		
		
		
		
	}

}
