package com.student.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet(name = "Signup", urlPatterns = { "/signuppage" })
public class Signup extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1604815650889123978L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean invalidName = false;
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean usernamePresent = QueryHelper.checkUsername(username);
		RequestDispatcher rd = request.getRequestDispatcher("/signup");
		PrintWriter out = response.getWriter();

		if (usernamePresent == true) {
			out.println("<font color=red>Username Already Present</font>");
			rd.include(request, response);

		} else {
			invalidName = Helper.signUp(name, username, email, password);
			if (invalidName == true) {
				out.println("<font color=red>Enter Valid Name.</font>");
				rd.include(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				response.sendRedirect("home");
			}
		}
	}

}
