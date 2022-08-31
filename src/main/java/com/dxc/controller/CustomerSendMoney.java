package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class CustomerSendMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("errorMsg", "");
		
		String username = (String) session.getAttribute("cusername");
		String to = request.getParameter("to");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		
		String msg = cm.sendMoney(to, amount);
		if (msg.equals("success")) {
			session.setAttribute("to", to);
			session.setAttribute("amount", amount);
			response.sendRedirect("/bankservicesystem/sendMoneySuccess.jsp");
		} else {
			session.setAttribute("errorMsg", msg);
			response.sendRedirect("/bankservicesystem/sendMoney.jsp");
		}
	}
}
