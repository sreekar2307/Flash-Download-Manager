package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Questions;
import models.Question;

@WebServlet(name = "question", urlPatterns = { "/question" })
public class specific_question extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Questions question = new Questions();
		Question sp= question.get_Question(Integer.parseInt(req.getParameter("question_id")));
		HttpSession specific_question = req.getSession();
		specific_question.setAttribute("specific_question", sp);
		resp.sendRedirect("question.jsp?id="+req.getParameter("question_id"));
	}
}
