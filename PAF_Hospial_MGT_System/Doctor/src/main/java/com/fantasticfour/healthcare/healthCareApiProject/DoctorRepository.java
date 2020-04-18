package com.fantasticfour.healthcare.healthCareApiProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DoctorRepository {
	
	Connection con = null;
	
	public DoctorRepository() {
		
		//DB Connection
		String url = "jdbc:mysql://localhost:3306/healthCareApiProject";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	//ViewDoctors
	public List<Doctor> getAllDoctors(){
		
		List<Doctor> doctors = new ArrayList<>();
		String sql = "select * from doctors";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Doctor d = new Doctor();
				d.setDocID(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
				d.setContactNo(rs.getString(4));
				
				doctors.add(d);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return doctors;
	}
	
	
	//ViewDoctor
	public Doctor getDoctor(int docID) {
		
		String sql = "select * from doctors where docID = "+docID;
		Doctor d = new Doctor();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				d.setDocID(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
				d.setContactNo(rs.getString(4));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return d;
	}
	
	
	
	//ViewAppointment
	/*public Appointment getAppointment(int appo_No) {
		
		String sql = "select * from appointment where appo_No = "+appo_No;
		Appointment a = new Appointment();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				a.setAppo_No(rs.getInt(1));
				a.setLocation(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDate(rs.getString(4));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return a;
	}*/	
	

	
	//InsertDoctor
	public void create(Doctor d1) {
		
		String sql = "insert into doctors values (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, d1.getDocID());
			pst.setString(2, d1.getName());
			pst.setString(3, d1.getSpecialization());
			pst.setString(4, d1.getContactNo());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	
	
		//InsertLogin
		public void createLogin(Doctor d1) {
			
			String sql = "insert into login values (?,?)";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, d1.getDocID());
				pst.setString(2, d1.getPassword());
				pst.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
				
		}
		
	
	
	//UpdateDoctor
	public void update(Doctor d1) {
		
		String sql = "update doctors set name=?, specialization=?, contactNo=? where docID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d1.getName());
			pst.setString(2, d1.getSpecialization());
			pst.setString(3, d1.getContactNo());
			pst.setInt(4, d1.getDocID());
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	
	//DeleteDoctor
	public void delete(int docID) {
		
		String sql = "delete from doctors where docID=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, docID);
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
		//DeleteLogin
		public void deleteLogin(int docID) {
			
			String sql = "delete from login where docID=?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, docID);
				pst.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	
	
	
	
	
}
