package com.student.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

/**
 * Servlet implementation class RemoveStudent
 */
@WebServlet(name = "RemoveStudent", urlPatterns = { "/deregister" })
public class Deregister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8129071074428054144L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Student");
		response.setContentType("text/html");

		PrintWriter print = response.getWriter();
		boolean invalidName = false;
		String removeName = request.getParameter("name");
		invalidName = Helper.checkCharacter(removeName);
		Filter equalName = new FilterPredicate("Name", FilterOperator.EQUAL, removeName);
		query.setFilter(equalName);
		PreparedQuery preparedQuery1 = datastore.prepare(query);
		boolean nameNotFound = true;
		if (!invalidName && !removeName.equals("")) {
		print.println("<html><head>");
		print.println("<title>Student Corner</title>");
		print.println("</head><body>");
		print.print("<br><form align=\"right\" action=\"/logout\"> " 
				+ "<button type=\"submit\">Logout</button></form>");
		print.println("<h2 align=\"center\">Remove Student Details</h2><br><br>");
		print.println("<form>\r\n");
		print.println("<button type=\"submit\" formaction=\"removeinfo\">Back</button></form><br><br>");
		print.println("<form method=\"post\" action=\"deregister\">\r\n");

			print.println("<table border=\"1\" align=\"center\"> ");
			print.println("<col width=\"130\">");
			print.println("<col width=\"130\">");
			print.println("<col width=\"130\">");
			print.println("<col width=\"130\">");
			print.println("<tr>" + "<th>Choose</th>" + "<th>ID</th>" + "<th>Name</th> " + "<th>Age</th>" + "</tr>");
			for (Entity entity : preparedQuery1.asIterable()) {
				long id = entity.getKey().getId();
				String name = entity.getProperty("Name").toString();
				int age = Integer.parseInt(entity.getProperty("Age").toString());
				if (name.equals(removeName)) {
					nameNotFound = false;
					print.println("<tr><td style=\"text-align:center\">");
					print.print("<input type=\"radio\" name=\"remove\" value=\"" + id + "\" required>");
					print.println("</td><td style=\"text-align:center\">");
					print.print(id);
					print.println("</td><td style=\"text-align:center\">");
					print.print(name);
					print.println("</td><td style=\"text-align:center\">");
					print.print(age);
					print.println("</td></tr> ");
					print.println("<br>");

				}
			}
			print.println("</table>");
			if (nameNotFound)
				print.println("<center>No Records Founds</center>");
			else
				print.println("<br><div align=\"center\"><button type=\"submit\">Remove Details</button></div>");

			print.println("</form");

			print.println("</body></html>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/removeinfo");
			print.println("<font color=red>Enter Valid Name.</font>");
			rd.include(request, response);
		}

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();

		long removeId = Long.parseLong(request.getParameter("remove"));
		QueryHelper.removeByIdQuery(removeId);

		pw.println("<html><body>");
		pw.print("<br><form align=\"right\" action=\"/logout\"> " 
				+ "<button type=\"submit\">Logout</button></form>");

		pw.println("Desired Record is removed.");

		pw.println("<br><br><form method=\"get\" action=\"/home\">\r\n"
				+ "    <button type=\"submit\">Back</button>\r\n" + "</form>");
		pw.println("</body></html>");
		pw.close();

	}
}
