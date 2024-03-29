package com.student.register;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("/filter")
public class Authenticate implements Filter {

	/**
	 * Default constructor.
	 */
	public Authenticate() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if (req.getRequestURI().startsWith("/_ah/") || req.getRequestURI().equals("/loginpage")
				|| req.getRequestURI().equals("/signuppage"))
			chain.doFilter(request, response);
		else {

			if (session != null) {
				String username = (String) session.getAttribute("username");
				String password = (String) session.getAttribute("password");
				boolean correctCredentials = false;
				correctCredentials = QueryHelper.checkCredentials(username, password);

				if (correctCredentials) {
					if (req.getRequestURI().equals("/login") || req.getRequestURI().equals("/")
							|| req.getRequestURI().equals("/signup"))
						res.sendRedirect("/home");
					else
						chain.doFilter(request, response);
				} else {
					session.invalidate();
					if (req.getRequestURI().equals("/login") || req.getRequestURI().equals("/signup"))
						chain.doFilter(request, response);
					else
						res.sendRedirect("/login");
				}

			} else {

				if (req.getRequestURI().equals("/login") || req.getRequestURI().equals("/signup"))
					chain.doFilter(request, response);

			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
