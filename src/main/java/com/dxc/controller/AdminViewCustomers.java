package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import com.dxc.model.AdminModel;
import com.dxc.model.CustomerModel;

public class AdminViewCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminModel am = new AdminModel();
		ArrayList<CustomerModel> cmList = am.getCustomerList();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("cmList", cmList);

		if (!cmList.isEmpty()) {
			response.sendRedirect("/bankservicesystem/customerListSuccess.jsp");
		} else {
			response.sendRedirect("/bankservicesystem/customerListFailure.html");
		}
	}
}
