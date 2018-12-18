package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Users;

@WebServlet(name = "register", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Users database = new Users();
		int flag = database.register(req.getParameter("usr"),req.getParameter("pwd"), req.getParameter("email"));
		if(flag==0)
		  req.getRequestDispatcher("login").forward(req, res);
		else if(flag==1)
		  res.sendRedirect("register.jsp?set=true");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect("register.jsp");
	}
}
