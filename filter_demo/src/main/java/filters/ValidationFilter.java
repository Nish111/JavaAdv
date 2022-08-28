package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String pan = request.getParameter("pan");
		// prevalidaton step for pan as filter takes load of servlet and preprocessing
		System.out.println("Hi from Filter");
		if(pan==null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<SPAN style='color:red'>Invalid Pan No.</SPAN>");
		} else {
			request.setAttribute("pan", pan);
			// pass the request along the filter chain
			chain.doFilter(request, response);
			System.out.println("Bye from Filter");
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
