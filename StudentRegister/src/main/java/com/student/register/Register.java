package com.student.register;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet(name = "Register", urlPatterns = { "/register" })
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -286060870575219564L;

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);

		if (session != null) {
		pw.println("<html><head>");
		pw.println("<title>Student Corner</title>");
		pw.println("</head><body>");
		pw.println("<h2 align=\"center\">Add Student Details</h2><br><br>");

		pw.println("<form action=\"register\" method=\"post\">" 
						+ "<button type=\"submit\" formaction=\"/home\">Back</button><br><br><br>"
						+ "Name: <input type=\"text\" name=\"name\" required/><br><br><br> "
						+ "Age: &nbsp;&nbsp;&nbsp;<input type=\"number\" name=\"age\" required/><br><br><br> "
						+ "<button type=\"submit\">Add Student</button></form>");
		pw.println("</body></html>");

	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		boolean invalidDetails;
		try {
			String name = request.getParameter("name");
			System.out.println(name);
			int age = Integer.parseInt(request.getParameter("age"));
			invalidDetails = Helper.addStudent(name, age);
		} catch (NumberFormatException e) {
			invalidDetails = true;
		}

		PrintWriter print = response.getWriter();
		print.println("<html><body>");
		if (!invalidDetails)
			print.println("Record added to Student Database");
		else
			print.println("Enter Valid Details");

		print.println("<br><br><form method=\"get\" action=\"/home\">\r\n"
				+ "    <button type=\"submit\">Back</button>\r\n" + "</form>");
		print.println("</body></html>");
		print.close();
	}
}
