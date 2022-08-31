package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.AdminModel;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminModel am = new AdminModel();
		am.setUsername(username);
		am.setPassword(password);
		
		String loginStatus = am.login();
		if (loginStatus.equals("success")) {
			session.setAttribute("ausername", username);
			response.sendRedirect("/bankservicesystem/admin.jsp");
		} else {
			session.setAttribute("errorMsg", loginStatus);
			response.sendRedirect("/bankservicesystem/adminLogin.jsp");
		}
	}
}
