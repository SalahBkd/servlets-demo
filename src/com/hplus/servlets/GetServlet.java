package com.hplus.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ServletConfig
		ServletConfig config = getServletConfig();
		System.out.println(config.getInitParameter("URL"));
		
		// ServletContext
		ServletContext context = getServletContext();
		System.out.println(context.getInitParameter("dbURL"));
		
		String html = "<html><h3>Hey there !!</h3></html>";
		PrintWriter writer = resp.getWriter();
		writer.write(html);
		
	}
}
