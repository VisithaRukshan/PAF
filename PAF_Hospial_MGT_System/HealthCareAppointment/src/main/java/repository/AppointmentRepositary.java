package repository;

import java.util.ArrayList;
import java.util.List;

import model.Appointment;

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
			a.setPatName(rs.getString(2));
			a.setdName(rs.getString(3));
			a.setDate(rs.getString(4));
			a.setTime(rs.getString(5));
			a.setLocation(rs.getString(6));
			
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
			a.setPatName(rs.getString(2));
			a.setdName(rs.getString(3));
			a.setDate(rs.getString(4));
			a.setTime(rs.getString(5));
			a.setLocation(rs.getString(6));
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
		}
		 
	

	public void create(Appointment A1) {
		String sql = "insert into appointment (patName, dName, date, time, location) values(?,?,?,?,?)";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		//st.setInt(1,  A1.getAppointNo());
		st.setString(1, A1.getPatName());
		st.setString(2, A1.getdName());
		st.setString(3,  A1.getDate());
		st.setString(4, A1.getTime());
		st.setString(5, A1.getLocation());
		st.executeUpdate();
	
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		}
		
	public void update(Appointment A1) {
		String sql = "update appointment set patName=?, dName=?, date=?, time=?, location=? where appointNo=? ";
		try
		{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, A1.getPatName());
		st.setString(2, A1.getdName());
		st.setString(3,  A1.getDate());
		st.setString(4, A1.getTime());
		st.setString(5, A1.getLocation());
		st.setInt(6,  A1.getAppointNo());
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