package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");

		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String pin = request.getParameter("pin");
		int deposit = Integer.parseInt(request.getParameter("initial deposit"));
		String securityQn = request.getParameter("security question");
		String securityAns = request.getParameter("security answer");
		
		CustomerModel cm = new CustomerModel();
		cm.setName(name);
		cm.setUsername(username);
		cm.setPin(pin);
		cm.setBalance(deposit);
		cm.setSecurityQn(securityQn);
		cm.setSecurityAns(securityAns);
		
		String errorMsg = cm.register();
		if (errorMsg.equals("success")) {
			session.setAttribute("cname", name);
			response.sendRedirect("/bankservicesystem/registerSuccess.jsp");
		} else {
			session.setAttribute("errorMsg", errorMsg);
			response.sendRedirect("/bankservicesystem/customerRegister.jsp");
		}
	}
}
