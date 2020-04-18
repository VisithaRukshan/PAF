package com.fantasticfour.healthcare.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaymentRepository {

	Connection con = null;
	
	public PaymentRepository() {
		
		//DB Connection
		String url = "jdbc:mysql://localhost:3306/healthCareApiProject"; //DB Name eka dgnin mcn. Tables name : payment, card
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	//Retrieve
	public Payment getPayment(int payID) {
		
		String sql = "select * from payment where payID = "+payID;
		Payment p = new Payment();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				p.setPayID(rs.getInt(1));
				p.setDate(rs.getString(2));
				p.setTime(rs.getString(3));
				p.setAmount(rs.getString(4));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return p;
	}
	


	//Insert
	public void create(Payment p1) {
		
		String sql = "insert into payment values (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p1.getPayID());
			pst.setString(2, p1.getDate());
			pst.setString(3, p1.getTime());
			pst.setString(4, p1.getAmount());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	
	
	//InsertCard
	public void createCard(Payment p1) {
		
		String sql = "insert into card values (?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p1.getPayID());
			pst.setString(2, p1.getCardNo());
			pst.setString(3, p1.getCvv());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	
	
	//Update
	public void update(Payment p1) {
		
		String sql = "update payment set date=?, time=?, amount=? where payID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p1.getDate());
			pst.setString(2, p1.getTime());
			pst.setString(3, p1.getAmount());
			pst.setInt(4, p1.getPayID());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	
	//Delete
	public void delete(int payID) {
		
		String sql = "delete from payment where payID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, payID);
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	//Delete
	public void deleteCard(int payID) {
		
		String sql = "delete from card where payID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, payID);
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
}
