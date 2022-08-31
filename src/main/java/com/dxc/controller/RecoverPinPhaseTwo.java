package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class RecoverPinPhaseTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");
		
		String username = (String) session.getAttribute("cusername");
		String securityAns = request.getParameter("security answer");
		String dBSecurityAns = (String) session.getAttribute("securityAns");
		
		String pin = "";
		if (securityAns.toLowerCase().equals(dBSecurityAns.toLowerCase())) {
			CustomerModel cm = new CustomerModel();
			cm.setUsername(username);
			pin = cm.getPinFromDb();
		}
		
		if (!pin.equals("")) {
			session.setAttribute("pin", pin);
			response.sendRedirect("/bankservicesystem/forgotPinSecurityQnA.jsp");
		} else {
			session.setAttribute("errorMsg", "incorrect answer");
			response.sendRedirect("/bankservicesystem/forgotPin.jsp");
		}
	}
}
