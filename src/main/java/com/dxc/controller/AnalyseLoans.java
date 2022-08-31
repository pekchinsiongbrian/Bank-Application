package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import com.dxc.model.AdminModel;
import com.dxc.model.LoanModel;

public class AnalyseLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminModel am = new AdminModel();
		String loanAnalysis = am.analyseLoans();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("loanAnalysis", loanAnalysis);

		response.sendRedirect("/bankservicesystem/loanAnalysis.jsp");
	}
}
