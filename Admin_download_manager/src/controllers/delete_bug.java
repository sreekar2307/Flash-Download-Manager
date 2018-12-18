package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Admin;


@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class delete_bug extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   Admin dao =new Admin();
   dao.delete_bug(Integer.parseInt(req.getParameter("id")));
   resp.sendRedirect("admin");
}
}
