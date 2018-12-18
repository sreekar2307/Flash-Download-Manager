package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Users;
import models.User;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession user_session = req.getSession();
		if(user_session.getAttribute("User")==null)
		{
			res.sendRedirect("login.jsp");
		}
		else {
			req.getRequestDispatcher("index").forward(req,res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Users database = new Users();
		PrintWriter out = res.getWriter();
		if(database.check_crenditials(req.getParameter("usr"),req.getParameter("pwd"))) {
			User user = new User(req.getParameter("usr"),database.get_email(req.getParameter("usr")));
			HttpSession user_session = req.getSession();
			user_session.setAttribute("User",user);
			user_session.setMaxInactiveInterval(60*15);
			RequestDispatcher view = req.getRequestDispatcher("index");
			view.forward(req,res);
		}
		else
		{
			out.println("Retry");
		}


	}
}
