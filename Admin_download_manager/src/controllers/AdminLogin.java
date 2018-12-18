package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Admin;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(name = "admin", urlPatterns = { "/admin" })
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession bugs = request.getSession();
		 Admin dao = new Admin();
		 bugs.setAttribute("processing_bugs",dao.get_BugReport_processing());  
		 response.sendRedirect("admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("adminUser");
		String password = request.getParameter("adminPass");
			if(username != null)		
			{    
				if(username.equals("rohith")&& password.equals("vonkai"))
				{
					 HttpSession bugs = request.getSession();
					 Admin dao = new Admin();
					 bugs.setAttribute("processing_bugs",dao.get_BugReport_processing());  
					 response.sendRedirect("admin.jsp");
				}
				else
				{
					out.println("Login Failed| Try again");
				}
			}
	}

}
