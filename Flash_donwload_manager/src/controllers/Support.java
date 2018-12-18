package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Questions;
import models.Thread;

@WebServlet(name = "support", urlPatterns = { "/support" })
public class Support extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Thread> Threads;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Questions question = new Questions();
			Threads = question.get_Threads();
			HttpSession display_questions = req.getSession();
			display_questions.setAttribute("Thread_list", Threads);
		    res.sendRedirect("support.jsp");
	}
}
