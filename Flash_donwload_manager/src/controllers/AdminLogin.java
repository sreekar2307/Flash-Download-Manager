package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(name ="abc",urlPatterns = { "/admin" })
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("adminUser");
		String password = request.getParameter("adminPass");
		try {
			if(username != null)
				
			{    System.out.println("ENtered if");
				if(username.equals("rohith")&& password.equals("vonkai"))
				{
					 System.out.println("correct pass");
					response.sendRedirect("welcome.jsp");
				}
				else
				{
					out.println("Login Failed| Try again");
				}
			}
		}catch(Exception e)
		{
			out.println("Error:"+e.getMessage());
		}
	}

}
