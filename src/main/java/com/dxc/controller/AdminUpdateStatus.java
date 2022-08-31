package com.dxc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.model.AdminModel;

public class AdminUpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String approve = request.getParameter("approve");
		String disapprove = request.getParameter("dispprove");
		int sn = Integer.parseInt(request.getParameter("sn"));
		int status = approve != null ? 1 : disapprove != null ? 0 : -1;
		if (status == -1) {
			response.sendRedirect("/bankservicesystem/adminUpdateStatusFailure.html");
		}
		
		AdminModel am = new AdminModel();
		int rows = am.setStatus(sn, status);
		if (rows > 0) {
			response.sendRedirect("/bankservicesystem/adminUpdateStatusSuccess.html");
		} else {
			response.sendRedirect("/bankservicesystem/adminUpdateStatusFailure.html");
		}
	}
}
