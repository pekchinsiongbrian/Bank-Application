package com.dxc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// For every table, create one model
public class CustomerModel {
	// all the columns as variables
	private String name;
	private String username;
	private String pin;
	private int deposit;
	private int balance;
	private String securityQn;
	private String securityAns;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getSecurityQn() {
		return securityQn;
	}

	public void setSecurityQn(String securityQn) {
		this.securityQn = securityQn;
	}

	public String getSecurityAns() {
		return securityAns;
	}

	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}

	public String register() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String checkId = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(checkId);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            if (res.next()) {
            	return "username";            
            } else {
            	String s = "insert into customer_details values(?, ?, ?, ?, ?, ?)";
                pstmt = con.prepareStatement(s);

                pstmt.setString(1, name);
                pstmt.setString(2, username);
                pstmt.setString(3, pin);
                pstmt.setInt(4, balance);
                pstmt.setString(5, securityQn);
                pstmt.setString(6, securityAns);
                
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                	return "success";
                } else {
                	return "error";
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "error";
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
            
            String checkId = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(checkId);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            if (res.next()) {
            	String pw = res.getString(3);
            	if (pw.equals(pin)) {
            		return "success";
            	} else {
            		return "pin";
            	}
            } else {
            	return "username";
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "error";
	}
	
	public String[] getSecurityQnA() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String checkId = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(checkId);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            if (res.next()) {
            	return new String[] {res.getString(5), res.getString(6)};
            } else {
            	return new String[] {};
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return new String[] {};
	}
	
	public String getPinFromDb() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String getPin = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(getPin);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            if (res.next()) {
            	return res.getString(3);
            } else {
            	return "";
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "";
	}
	
	public int changePin(String newPin) {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String getPin = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(getPin);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
        	if (res.next()) {
        		if (res.getString(3).equals(pin)) {
        			String s = "update customer_details set pin=? where username=?";
            		pstmt = con.prepareStatement(s);
            		pstmt.setString(1, newPin);
            		pstmt.setString(2, username);
            		int rows = pstmt.executeUpdate();
            		return rows;
        		}
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return 0;
	}
	
	public int checkBalance() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String getBalance = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(getBalance);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
        	if (res.next()) {
        		return res.getInt(4);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return -1;
	}
	
	public String sendMoney(String to, int amount) {
		Connection con = null;
        ResultSet resSelf = null;
        ResultSet resRecipient = null;
        PreparedStatement pstmt = null;
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String getBal = "select * from customer_details where username=?";
            pstmt = con.prepareStatement(getBal);
            pstmt.setString(1, username);
            resSelf = pstmt.executeQuery();
            
            pstmt = con.prepareStatement(getBal);
            pstmt.setString(1, to);
            resRecipient = pstmt.executeQuery();
        	if (resRecipient.next() && resSelf.next()) {
        		int currOwnBal = resSelf.getInt(4);
        		int currRecipientBal = resRecipient.getInt(4);
        		if (amount <= currOwnBal) {
        			// update own balance
        			String updateBal = "update customer_details set balance=? where username=?";
        			pstmt = con.prepareStatement(updateBal);
        			pstmt.setInt(1,  currOwnBal - amount);
        			pstmt.setString(2, username);
        			pstmt.executeUpdate();
        			
        			pstmt = con.prepareStatement(updateBal);
        			pstmt.setInt(1, currRecipientBal + amount);
        			pstmt.setString(2, to);
        			pstmt.executeUpdate();
        			
        			String updateTransactions = "insert into transactions values(?, ?, ?)";
        			pstmt = con.prepareStatement(updateTransactions);

                    pstmt.setString(1, username);
                    pstmt.setString(2, to);
                    pstmt.setInt(3, amount);
                    pstmt.executeUpdate();        			
        			
                    return "success";
        		} else {
        			return "You don't have enough money to send!";
        		}
        	} else {
        		return "Recipient username does not exist";
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "error";
	}
	
	public int applyLoan(int loanAmount, String loanType) {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        int rows = 0;
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "insert into pending_approval (username, loan_amount, loan_type) values(?, ?, ?)";
            pstmt = con.prepareStatement(s);
            pstmt.setString(1, username);
            pstmt.setInt(2, loanAmount);
            pstmt.setString(3, loanType);
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return rows;
	}
	
	public ArrayList<LoanModel> getLoans() {
		Connection con = null;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        
        ArrayList<LoanModel> loanList = new ArrayList<LoanModel>();
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from loans where username=?";
            pstmt = con.prepareStatement(s);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            while (res.next()) {
            	LoanModel lm = new LoanModel();
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
        
        ArrayList<LoanModel> pendingLoanList = new ArrayList<LoanModel>();
        
		try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
            System.out.println("Connection established successfully");
            
            String s = "select * from pending_approval where username=?";
            pstmt = con.prepareStatement(s);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            while (res.next()) {
            	LoanModel lm = new LoanModel();
            	lm.setLoanAmount(res.getInt(3));
            	lm.setLoanType(res.getString(4));
            	pendingLoanList.add(lm);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pendingLoanList;
	}
	
//	public int addCarDetails() {
//		Connection con = null;
//        PreparedStatement pstmt = null;
//        
//		try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            System.out.println("Driver loaded successfully");
//
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
//            System.out.println("Connection established successfully");
//            
//			String s = "insert into car_details values(?, ?, ?, ?, ?, ?)";
//			pstmt = con.prepareStatement(s);
//			pstmt.setString(1, username);
//			pstmt.setString(2, carModel);
//			pstmt.setString(3, carType);
//			pstmt.setString(4, carRegistrationNumber);
//			pstmt.setString(5, "false");
//			pstmt.setString(6, "false");
//			
//			int rows = pstmt.executeUpdate();
//			return rows;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	
//	public int requestService() {
//		Connection con = null;
//        PreparedStatement pstmt = null;
//        
//		try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            System.out.println("Driver loaded successfully");
//
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
//            System.out.println("Connection established successfully");
//            
//            String s = "update car_details set servicereq=?, status=? where cun=?";
//            pstmt = con.prepareStatement(s);
//			pstmt.setString(1, serviceRequest);
//			pstmt.setString(2, "false");
//			pstmt.setString(3, username);
//			
//			int rows = pstmt.executeUpdate();
//			return rows;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	
//	public boolean getServiceStatus() {
//		Connection con = null;
//		ResultSet res = null;
//        PreparedStatement pstmt = null;
//        
//		try {
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            System.out.println("Driver loaded successfully");
//
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_project", "root", "root123");
//            System.out.println("Connection established successfully");
//            
//            String s = "select * from car_details where cun=?";
//            pstmt = con.prepareStatement(s);
//			pstmt.setString(1, username);
//			
//			res = pstmt.executeQuery();
//			if (res.next()) {
//				String status = res.getString(6);
//				return status.equals("true");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;		
//	}
}
