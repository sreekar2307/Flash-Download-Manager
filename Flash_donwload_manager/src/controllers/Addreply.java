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
@WebServlet(name = "add_reply", urlPatterns = { "/addreply" })
public class Addreply extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("in here");
		HttpSession user_session = req.getSession();
		if(user_session.getAttribute("User")==null)
			res.sendRedirect("login");
		else {
		  Questions new_reply = new Questions();
		  User logged_in_user =(User)user_session.getAttribute("User");
		  new_reply.Insert_Reply(Integer.parseInt(req.getParameter("question_id")), req.getParameter("reply_desc"),logged_in_user.getUsername());
		  res.sendRedirect("question?question_id="+req.getParameter("question_id"));
		}
	}
}
