package com.student.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
@WebServlet(name = "Signup", urlPatterns = { "/signup" })
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean invalidName = false;
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean usernamePresent = QueryHelper.checkUsername(username);
		RequestDispatcher rd = request.getRequestDispatcher("/signup.html");
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
				RequestDispatcher redirect = request.getRequestDispatcher("/login.html");
				redirect.forward(request, response);
			}
		}
	}

}
