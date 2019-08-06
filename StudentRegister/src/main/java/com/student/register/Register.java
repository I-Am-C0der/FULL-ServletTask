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
 * Servlet implementation class AddStudent
 */
@WebServlet(name = "Register", urlPatterns = { "/register" })
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -286060870575219564L;

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		boolean invalidDetails;
		String name = request.getParameter("name");

		try {
			int age = Integer.parseInt(request.getParameter("age"));
			invalidDetails = Helper.checkCharacter(name);
			invalidDetails = Helper.addStudent(name, age);
		} catch (NumberFormatException e) {
			invalidDetails = true;
		}

		PrintWriter print = response.getWriter();
		if (!invalidDetails && !name.equals("")) {
		print.println("<html><body>");
		print.print("<br><form align=\"right\" action=\"/logout\"> " 
				+ "<button type=\"submit\">Logout</button></form>");
		print.println("<br><br><form method=\"get\" action=\"/home\">\r\n"
				+ "    <button type=\"submit\">Home</button>\r\n" + "</form>");
			print.println("Record added to Student Database");
		

		
		print.println("</body></html>");
		print.close();
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/addinfo");
			print.println("<font color=red>Enter Valid Name or Age.</font>");
			rd.forward(request, response);
		}
	}
}
