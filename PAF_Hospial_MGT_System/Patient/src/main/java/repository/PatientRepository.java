package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.sql.*;
import java.sql.Statement;

public class PatientRepository {

	List<Patient> patients;
	Connection con = null;

	public PatientRepository() {
		//String url = "jdbc:mysql://127.0.0.1:3306/healthcareapi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Patient> getAllPatients() {
		List<Patient> patient = new ArrayList<>();
		//String query = "Select * from patient";
		String query = "Select * from ptable";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Patient p = new Patient();
				p.setPnic(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setGender(rs.getString(3));
				p.setPhonenumber(rs.getString(4));
				p.setUsername(rs.getString(5));
				p.setPassword(rs.getString(6));
				patient.add(p);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return patient;
	}

	public Patient getPatient(int pnic) {
		System.out.println(pnic);
		//String query = "Select * from patient where pnic =" + pnic;
		String query = "Select * from ptable where pnic =" + pnic;
		Patient p = new Patient();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {

				p.setPnic(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setGender(rs.getString(3));
				p.setPhonenumber(rs.getString(4));
				p.setUsername(rs.getString(5));
				p.setPassword(rs.getString(6));

			}
			System.out.println("Patient " + pnic + " get successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	public void create(Patient p) {
		String query = "Insert into ptable values (?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, p.getPnic());
			st.setString(2, p.getPname());
			st.setString(3, p.getGender());
			st.setString(4, p.getPhonenumber());
			st.setString(5, p.getUsername());
			st.setString(6, p.getPassword());
			st.executeUpdate();
			System.out.println(" " + p.getPname() + " created successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Patient p) {
		String query = "Update ptable set name=?,gender=?,phonenumber=?,username=?,password=? where pnic=?";
		//String query = "Update patient set name=?,gender=?,phonenumber=?,username=?,password=? where pnic=?";
		try {
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, p.getPname());
			st.setString(2, p.getGender());
			st.setString(3, p.getPhonenumber());
			st.setString(4, p.getUsername());
			st.setString(5, p.getPassword());
			st.setInt(6, p.getPnic());
			st.executeUpdate();

			System.out.println("" + p.getPname() + "details updated successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//delete patient
	public void delete(int pnic) {
		System.out.println(pnic);
		String query = "Delete from ptable where pnic=?";
		//String query = "Delete from patient where pnic=?";

		try {
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, pnic);
			st.executeUpdate();

			System.out.println("" + pnic + "Patient profile deleted successfully");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// hospital view
	public List<Hospital> getHospitals() {
		List<Hospital> hospitals = new ArrayList<>();
		String sql = "select * from hospital";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Hospital h = new Hospital();
				h.setHostId(rs.getInt(1));

				h.setTeleNo(rs.getString(2));
				h.setName(rs.getString(3));
				h.setLocation(rs.getString(4));
				hospitals.add(h);
			}
			System.out.println("Hospital retrive successfully");

		} catch (Exception e) {
			System.out.println(e);
		}

		return hospitals;
	}

	// get Doctor view
	public List<Doctor> getAllDoctors() {

		List<Doctor> doctors = new ArrayList<>();
		String sql = "select * from doctors";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Doctor d = new Doctor();
				d.setDocID(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
				d.setContactNo(rs.getString(4));

				doctors.add(d);
			}
			System.out.println("Doctor retrive successfully");

		} catch (Exception e) {
			System.out.println(e);
		}

		return doctors;
	}

	// make appoinment
	public void create(Appointment a) {
		String query = "Insert into appoinment values (?,?,?,?,?,?)";
		//String query = "Insert into appointment values (?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, a.getAppointNo());
			st.setString(2, a.getPname());
			st.setString(3, a.getDname());
			st.setString(4, a.getDate());
			st.setString(5, a.getTime());
			st.setString(6, a.getLocation());
			st.executeUpdate();

			System.out.println("Appointment id  " + a.getAppointNo() + " place Appointment successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Retrieve Appointment

	public Appointment getAppointment(int appointNo) {
		String sql = "select * from appoinment where appointNo=" + appointNo;
		//String sql = "select * from appointment where appointNo=" + appointNo;
		Appointment a = new Appointment();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				a.setAppointNo(rs.getInt(1));
				a.setPname(rs.getString(2));
				a.setDname(rs.getString(3));
				a.setDate(rs.getString(4));
				a.setTime(rs.getString(5));
				a.setLocation(rs.getString(6));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}
	
	
}
