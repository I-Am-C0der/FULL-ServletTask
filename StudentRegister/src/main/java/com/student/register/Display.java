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
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;

/**
 * Servlet implementation class DisplayStudent
 */
@WebServlet(name = "DisplayStudent", urlPatterns = { "/display" })
public class Display extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4882399665743872867L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Student");
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("/displayinfo");

		PrintWriter print = response.getWriter();
		String getName = request.getParameter("name");
		boolean invalidDetails = Helper.checkCharacter(getName);
		if (request.getParameter("display") == null) {
			print.println("<font color=red>Choose a valid option.</font>");
			rd.forward(request, response);

		} else if (Integer.parseInt(request.getParameter("display")) == 2 && getName.equals("") || invalidDetails ) {
			
				print.println("<font color=red>Enter Valid Name.</font>");
				rd.forward(request, response);

		} else {

			print.println("<html><body>");
			print.print("<br><form align=\"right\" action=\"/logout\"> "
					+ "<button type=\"submit\">Logout</button></form>");
			print.println("<h1 align=\"center\">Student Record</h1>");
			print.println("<br><br><form method=\"get\" action=\"/home\">\r\n"
					+ "<button type=\"submit\">Home</button>&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<button type=\"submit\" formaction=\"/displayinfo\">Back</button>" + "</form>");

			int displayOption = Integer.parseInt(request.getParameter("display"));
			switch (displayOption) {
			case 3:
				print.println("<table border=\"1\" align=\"center\"> ");
				print.println("<col width=\"130\">");
				print.println("<col width=\"130\">");
				print.println("<col width=\"130\">");
				print.println("<tr>" + "<th>ID</th>" + "<th>Name</th> " + "<th>Age</th>" + "</tr>");
				query.addSort("Name", SortDirection.ASCENDING);
				PreparedQuery preparedQuery = datastore.prepare(query);
				for (Entity entity : preparedQuery.asIterable()) {
					long id = entity.getKey().getId();
					String name = entity.getProperty("Name").toString();
					int age = Integer.parseInt(entity.getProperty("Age").toString());
					print.println("<tr><td style=\"text-align:center\">");
					print.print(id);
					print.println("</td><td style=\"text-align:center\">");
					print.print(name);
					print.println("</td><td style=\"text-align:center\">");
					print.print(age);
					print.println("</td></tr> ");
					print.println("<br>");
				}
				print.println("</table>");
				break;
			case 2:

				print.println("<table border=\"1\" align=\"center\"> ");
				print.println("<col width=\"130\">");
				print.println("<col width=\"130\">");
				print.println("<col width=\"130\">");
				print.println("<tr>" + "<th>ID</th>" + "<th>Name</th> " + "<th>Age</th>" + "</tr>");
				Filter equalName = new FilterPredicate("Name", FilterOperator.EQUAL, getName);
				query.setFilter(equalName);
				PreparedQuery preparedQuery1 = datastore.prepare(query);
				for (Entity entity : preparedQuery1.asIterable()) {
					long id = entity.getKey().getId();
					String name = entity.getProperty("Name").toString();
					int age = Integer.parseInt(entity.getProperty("Age").toString());
					print.println("<tr><td>");
					print.print(id);
					print.println("</td><td>");
					print.print(name);
					print.println("</td><td>");
					print.print(age);
					print.println("</td></tr> ");
					print.println("<br>");
				}
				print.println("</table>");

				break;
			case 1:

				try {
					int getAge = Integer.parseInt(request.getParameter("age"));
					if (request.getParameter("filter") == null) {
						print.println("Choose a valid option.");

					} else {
						int filterOption = Integer.parseInt(request.getParameter("filter"));
						Filter greaterThanFilter = new FilterPredicate("Age", FilterOperator.GREATER_THAN, getAge);
						Filter lesserThanFilter = new FilterPredicate("Age", FilterOperator.LESS_THAN, getAge);
						print.println("<table border=\"1\" align=\"center\"> ");
						print.println("<col width=\"130\">");
						print.println("<col width=\"130\">");
						print.println("<col width=\"130\">");
						print.println("<tr>" + "<th>ID</th>" + "<th>Name</th> " + "<th>Age</th>" + "</tr>");
						if (filterOption == 1)
							query.setFilter(greaterThanFilter);
						else
							query.setFilter(lesserThanFilter);
						PreparedQuery preparedQuery2 = datastore.prepare(query);
						for (Entity entity : preparedQuery2.asIterable()) {
							long id = entity.getKey().getId();
							String name = entity.getProperty("Name").toString();
							int age = Integer.parseInt(entity.getProperty("Age").toString());
							print.println("<tr><td>");
							print.print(id);
							print.println("</td><td>");
							print.print(name);
							print.println("</td><td>");
							print.print(age);
							print.println("</td></tr> ");
							print.println("<br>");
						}
						print.println("</table>");
					}
				} catch (NumberFormatException e) {
					print.println("Enter Valid Age");
				}

			}
			print.println("</body></html>");
		}

		print.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
