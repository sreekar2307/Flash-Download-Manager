package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Questions;
import models.User;

@WebServlet(name = "new_question", urlPatterns = { "/new_question" })
public class Ask_a_question extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession user_session = req.getSession();
		if(user_session.getAttribute("User")==null)
			res.sendRedirect("login");
		else {
		  Questions new_question = new Questions();
		  new_question.insert_question(req.getParameter("title"),
				  req.getParameter("desc"),
				  ((User)user_session.getAttribute("User")).getUsername());
		  res.sendRedirect("support");
		}
	}
}
