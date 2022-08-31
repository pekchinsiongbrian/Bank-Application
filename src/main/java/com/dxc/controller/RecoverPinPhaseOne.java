package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class RecoverPinPhaseOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");
		
		String username = request.getParameter("username");
		session.setAttribute("cusername", username);
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		String[] securityQnA = cm.getSecurityQnA();
		
		if (securityQnA.length > 0) {
			session.setAttribute("securityQn", securityQnA[0]);
			session.setAttribute("securityAns", securityQnA[1]);
			response.sendRedirect("/bankservicesystem/forgotPinSecurityQnA.jsp");
		} else {
			session.setAttribute("errorMsg", "no such username");
			response.sendRedirect("/bankservicesystem/forgotPin.jsp");
		}
	}
}
