package com.hplus.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testscopes")
public class ScopesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String username = req.getParameter("userame");
		req.setAttribute("username", username);
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		ServletContext context = req.getServletContext();
		context.setAttribute("username", username);
		
		writer.write("request data " + req.getAttribute("username"));
		writer.write("session data " + (String)session.getAttribute("username"));
		writer.write("context data " + (String)context.getAttribute("username"));
	}
}
