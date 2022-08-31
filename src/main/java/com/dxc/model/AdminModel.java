package com.dxc.model;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminModel {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from admin_details where username=?";
            pstmt = con.prepareStatement(s);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            if (res.next()) {
            	String pw = res.getString(2);
            	if (pw.equals(password)) {
            		return "success";
            	} else {
            		return "password";
            	}
            } else {
            	return "username";
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "error";
	}
	
	public ArrayList<CustomerModel> getCustomerList() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
        ArrayList<CustomerModel> cmList = new ArrayList<CustomerModel>();
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from customer_details";
            pstmt = con.prepareStatement(s);
            res = pstmt.executeQuery();
            while (res.next()) {
            	CustomerModel cm = new CustomerModel();
            	cm.setName(res.getString(1));
            	cm.setUsername(res.getString(2));
            	cm.setBalance(res.getInt(4));
            	cmList.add(cm);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmList;
	}
	
	public ArrayList<LoanModel> getLoanList() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
        ArrayList<LoanModel> loanList = new ArrayList<LoanModel>();
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from loans";
            pstmt = con.prepareStatement(s);
            res = pstmt.executeQuery();
            while (res.next()) {
            	LoanModel lm = new LoanModel();
            	lm.setUsername(res.getString(1));
            	lm.setLoanAmount(res.getInt(2));
            	lm.setLoanType(res.getString(3));
            	loanList.add(lm);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loanList;
	}
	
	public ArrayList<LoanModel> getPendingLoans() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
        ArrayList<LoanModel> loanList = new ArrayList<LoanModel>();
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from pending_approval";
            pstmt = con.prepareStatement(s);
            res = pstmt.executeQuery();
            while (res.next()) {
            	LoanModel lm = new LoanModel();
            	lm.setSn(res.getInt(1));
            	lm.setUsername(res.getString(2));
            	lm.setLoanAmount(res.getInt(3));
            	lm.setLoanType(res.getString(4));
            	loanList.add(lm);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loanList;
	}
	
	public int setStatus(int sn, int status) {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            int rows;
            
            String getUsername = "select * from pending_approval where sn=?";
            pstmt = con.prepareStatement(getUsername);
            pstmt.setInt(1, sn);
            res = pstmt.executeQuery();
            LoanModel loan = new LoanModel();
            if (res.next()) {
            	loan.setUsername(res.getString(2));
            	loan.setLoanAmount(res.getInt(3));
            	loan.setLoanType(res.getString(4));
            } else {
            	return 0;
            }
            
            String s = "delete from pending_approval where sn=?";
            pstmt = con.prepareStatement(s);
            pstmt.setInt(1, sn);
            rows = pstmt.executeUpdate();
            if (rows == 0) {
            	return 0;
            }
            if (status == 1) {
            	s = "select * from customer_details where username=?";
            	pstmt = con.prepareStatement(s);
            	pstmt.setString(1, loan.getUsername());
            	res = pstmt.executeQuery();
            	if (res.next()) {
            		int balance = res.getInt(4);
            		int newBalance = balance + loan.getLoanAmount();
            		s = "update customer_details set balance=? where username=?";
            		pstmt = con.prepareStatement(s);
            		pstmt.setInt(1, newBalance);
            		pstmt.setString(2, loan.getUsername());
            		rows = pstmt.executeUpdate();
            		if (rows == 0) {
                    	return 0;
                    }
            		
            		s = "insert into loans values(?, ?, ?)";
            		pstmt = con.prepareStatement(s);
            		pstmt.setString(1, loan.getUsername());
            		pstmt.setInt(2, loan.getLoanAmount());
            		pstmt.setString(3, loan.getLoanType());
            		rows = pstmt.executeUpdate();
            		if (rows == 0) {
                    	return 0;
                    }
            		return rows;
            	} else {
            		return 0;
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String analyseLoans() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
        String loanAnalysis = "";
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from loans";
            pstmt = con.prepareStatement(s);
            res = pstmt.executeQuery();
            int personalCount = 0, housingCount = 0, vehicleCount = 0;
            while (res.next()) {
            	String loanType = res.getString(3);
            	switch(loanType) {
            	case "personal":
            		personalCount++;
            		break;
            	case "housing":
            		housingCount++;
            		break;
            	case "vehicle":
            		vehicleCount++;
            		break;
            	default:
            		break;
            	}
            }
            Double total = Double.valueOf(vehicleCount + housingCount + vehicleCount);
            Double personalPercent = Double.valueOf(personalCount) / total * 100;
            Double housingPercent = Double.valueOf(housingCount) / total * 100;
            Double vehiclePercent = Double.valueOf(vehicleCount) / total * 100;
            loanAnalysis += "There are a total of " + Math.round(total) + " loans. " + personalPercent + "% of them are personal loans, " + housingPercent + "% of them are housing loans, and " + vehiclePercent + "% of them are vehicle loans.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loanAnalysis;
	}
}
