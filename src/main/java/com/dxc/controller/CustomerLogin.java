package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");
		
		String username = request.getParameter("username");
		String pin = request.getParameter("pin");
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		cm.setPin(pin);
		
		String loginStatus = cm.login();
		if (loginStatus.equals("success")) {
			session.setAttribute("cusername", username);
			response.sendRedirect("/bankservicesystem/customer.jsp");
		} else {
			session.setAttribute("errorMsg", loginStatus);
			response.sendRedirect("/bankservicesystem/customerLogin.jsp");
		}
	}
}
