package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

@WebServlet(name = "index", urlPatterns = { "/index" })
public class Index extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      HttpSession user_session = req.getSession();
      if(user_session.getAttribute("User")!=null) {
    	  User user = (User)user_session.getAttribute("User");
    	  res.sendRedirect("index.jsp");
      }
      else {
    	  res.sendRedirect("index.jsp");
      }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
