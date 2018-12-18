package controllers;
import database.Dao;
import models.BugReport;
import models.User;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class BugReportCont
 */
@WebServlet(name ="BugReport",urlPatterns = { "/BugReport" })
public class BugReportCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("BugReport.jsp");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String BugReportTitle = request.getParameter("BugReportTitle");
			 String BugReportDescription = request.getParameter("BugReportDescription");
			 HttpSession user_session = request.getSession();
				if(user_session.getAttribute("User")==null)
				{
					response.sendRedirect("login"); 
				}
				else {
					Dao dao = new Dao();
		            dao.BugReport(BugReportTitle, BugReportDescription,((User)user_session.getAttribute("User")).getUsername());
		            response.sendRedirect("index.jsp");
				}

		        
			
		
	
	
	
	}
	
	
	

}
