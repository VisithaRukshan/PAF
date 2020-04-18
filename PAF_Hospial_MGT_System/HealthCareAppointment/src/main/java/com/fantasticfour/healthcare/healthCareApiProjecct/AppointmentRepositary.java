package com.fantasticfour.healthcare.healthCareApiProjecct;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AppointmentRepositary {

	
	Connection con = null;
	
	public AppointmentRepositary()
	{
		String url = "jdbc:mysql://localhost:3306/healthcareapiproject";
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			System.out.println(e);
		} 
	}
	
	public List<Appointment> getAllAppointments()
	{
		List<Appointment> appointments = new ArrayList<>();
		String sql = "select * from appointment";
		try
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			Appointment a = new Appointment();
			a.setAppointNo(rs.getInt(1));
			a.setDate(rs.getString(2));
			a.setTime(rs.getString(3));
			a.setLocation(rs.getString(4));
			
			appointments.add(a);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return appointments;
	}
	
	public Appointment getAppointment(int appointNo)
	{
		String sql = "select * from appointment where appointNo="+appointNo;
		Appointment a = new Appointment();
		try
		{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next())
		{
		
			a.setAppointNo(rs.getInt(1));
			a.setDate(rs.getString(2));
			a.setTime(rs.getString(3));
			a.setLocation(rs.getString(4));
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
		}
		 
	

	public void create(Appointment A1) {
		String sql = "insert into appointment values(?,?,?,?)";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,  A1.getAppointNo());
		st.setString(2,  A1.getDate());
		st.setString(3, A1.getTime());
		st.setString(4, A1.getLocation());
		st.executeUpdate();
	
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		}
		
	public void update(Appointment A1) {
		String sql = "update appointment set date=?, time=?, location=? where appointNo=? ";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,  A1.getDate());
		st.setString(2, A1.getTime());
		st.setString(3, A1.getLocation());
		st.setInt(4,  A1.getAppointNo());
		st.executeUpdate();
	
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void delete(int appointNo) {
		
		String sql = "delete from appointment where appointNo=?";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, appointNo);
		st.executeUpdate();
	
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
		


	

