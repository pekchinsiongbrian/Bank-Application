package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class CustomerChangePin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");
		
		String username = (String) session.getAttribute("cusername");
		String oldPin = request.getParameter("old pin");
		String newPin = request.getParameter("new pin");
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		cm.setPin(oldPin);
		
		int rows = cm.changePin(newPin);
		if (rows > 0) {
			response.sendRedirect("/bankservicesystem/changePinSuccess.html");
		} else {
			session.setAttribute("errorMsg", "pin");
			response.sendRedirect("/bankservicesystem/changePin.jsp");
		}
	}
}
