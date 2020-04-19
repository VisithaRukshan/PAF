package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Payment;

public class PaymentRepository {

	Connection con = null;
	
	public PaymentRepository() {
		
		//DB Connection
		String url = "jdbc:mysql://localhost:3306/payment"; 
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
				p.setPid(rs.getString(2));
				p.setPname(rs.getString(3));
				p.setDname(rs.getString(4));
				p.setLocation(rs.getString(5));
				p.setDate(rs.getString(6));
				p.setTime(rs.getString(7));
				p.setAmount(rs.getString(8));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return p;
	}
	
	//View all
	
	public List<Payment> getAllPayment(){
		List<Payment> payments = new ArrayList<>();
		String sql = "select * from payment";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Payment p = new Payment();
				p.setPayID(rs.getInt(1));
				p.setPid(rs.getString(2));
				p.setPname(rs.getString(3));
				p.setDname(rs.getString(4));
				p.setLocation(rs.getString(5));
				p.setDate(rs.getString(6));
				p.setTime(rs.getString(7));
				p.setAmount(rs.getString(8));
				
				
				payments.add(p);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return payments;
	}


	//Insert
	public void create(Payment p1) {
		
		String amount="1000.00";
		String pname = null;
		String dname = null;
		String location = null;
		
		System.out.println(p1.getPid());
		
		String sql1 = "select * from appointment where pid ="+p1.getPid();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);
			
			while (rs.next()) {
				pname = rs.getString("name"); 
				dname = rs.getString("dname");
				location = rs.getString("location");
				
				System.out.println(pname + dname + location);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String sql = "insert into payment values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p1.getPayID());
			pst.setString(2, p1.getPid());
			pst.setString(3, pname);
			pst.setString(4, dname);
			pst.setString(5, location);
			pst.setString(6, p1.getDate());
			pst.setString(7, p1.getTime());
			pst.setString(8, amount);
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
			pst.setString(1, p1.getPid());
			pst.setString(2, p1.getCardNo());
			pst.setString(3, p1.getCvv());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	
	
	//CardUpdate
	public void update(Payment p1) {
		
		String sql = "update card set cardNo=?, cvv=? where pid=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p1.getCardNo());
			pst.setString(2, p1.getCvv());
			pst.setString(3, p1.getPid());
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
	public void deleteCard(int pid) {
		
		String sql = "delete from card where pid=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
}
