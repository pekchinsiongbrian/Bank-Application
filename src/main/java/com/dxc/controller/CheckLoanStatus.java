package com.dxc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;
import com.dxc.model.LoanModel;

public class CheckLoanStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String username = (String) session.getAttribute("cusername");
		
		CustomerModel cm = new CustomerModel();
		cm.setUsername(username);
		
		ArrayList<LoanModel> loanList = cm.getLoans();
		ArrayList<LoanModel> pendingLoanList = cm.getPendingLoans();
		session.setAttribute("loanList", loanList);
		session.setAttribute("pendingLoanList", pendingLoanList);
		response.sendRedirect("/bankservicesystem/checkLoanStatus.jsp");

	}
}
