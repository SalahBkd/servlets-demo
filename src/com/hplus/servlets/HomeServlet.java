package com.hplus.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hplus.dao.DBConnection;

public class HomeServlet extends HttpServlet {
	
	public Connection connection = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/html/index.html").forward(req, resp);
		System.out.println("inside doGet method.");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("inisde init method.");
		connection = DBConnection.getConnectionToDatabase();
	}
	
	@Override
	public void destroy() {
		System.out.println("inside destroy method.");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
