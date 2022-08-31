package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String username = (String) session.getAttribute("cusername");
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		
		int balance = cm.checkBalance();
		if (balance > -1) {
			session.setAttribute("balance", balance);
			response.sendRedirect("/bankservicesystem/checkBalance.jsp");
		} else {
			session.setAttribute("errorMsg", "error");
			response.sendRedirect("/bankservicesystem/customer.jsp");
		}
	}
}
