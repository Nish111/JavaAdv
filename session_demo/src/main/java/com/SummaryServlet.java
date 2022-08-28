package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class FirstServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
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
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setCity(request.getParameter("city")); 
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<h2> Hello " + u.getEmail() + "<h2>");
			out.println("<h3> Details " + u + "<h3>");
			out.println("<h4> Session id is " + session.getId() + "<h4>");
			out.println("<h4> Session created at " + session.getCreationTime() + "<h4>");
			session.invalidate(); // once user logs out we call invalidate to invalidate the session
		}
		
		
		
		
	}

}
