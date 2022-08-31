package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

public class ApplyLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String username = (String) session.getAttribute("cusername");
		int loanAmount = Integer.parseInt(request.getParameter("loan"));
		String loanType = request.getParameter("loan type");
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		
		int rows = cm.applyLoan(loanAmount, loanType);
		if (rows > 0) {
			session.setAttribute("loan_amount", loanAmount);
			session.setAttribute("loan_type", loanType);
			response.sendRedirect("/bankservicesystem/applyLoanSuccess.jsp");
		} else {
			session.setAttribute("errorMsg", "error");
			response.sendRedirect("/bankservicesystem/customer.jsp");
		}
	}
}
