package com.fantasticfour.healthcare.healthCareApiProject;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Appointment;
import model.Doctor;
import model.Hospital;
import model.Patient;
import repository.PatientRepository;

@Path("patients")
public class PatientResourse {
	PatientRepository repo = new PatientRepository();

	// get all patients
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getPatients() {
		System.out.println("get all call");
		return repo.getAllPatients();

	}

	// get particular patient
	@GET
	@Path("patient/{pnic}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("pnic") int pnic) {
		System.out.println(pnic);
		return repo.getPatient(pnic);
	}

	// create patient
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient createPatient(Patient p) {

		System.out.println(p);
		repo.create(p);

		return p;
	}

	// update patient
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient updatePatient(Patient p) {

		System.out.println(p);
		if (repo.getPatient(p.getPnic()).getPnic() == 0) {
			repo.create(p);
		} else {
			repo.update(p);
		}
		return p;
	}

	// delete patient
	@DELETE
	@Path("delete/{pnic}")
	public Patient deletePatient(@PathParam("pnic") int pnic) {
		System.out.println(pnic);

		Patient p = repo.getPatient(pnic);
		if (p.getPnic() != 0) {
			repo.delete(pnic);
		}
		return p;
	}

	// hospital view
	@GET
	@Path("hospital")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getHospitals() {
		System.out.println("getHospital called..");
		return repo.getHospitals();
	}

	// doctor view
	@GET
	@Path("doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getAllDoctors() {

		System.out.println("All Doctors called......");
		return repo.getAllDoctors();
	}

	// place appointment
	@POST
	@Path("appointment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Appointment createAppointment(Appointment A1) {
		System.out.println(A1);
		repo.create(A1);
		return A1;
	}

	// Retrieve paticular appointment
	@GET
	@Path("appointment/{appointNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointment(@PathParam("appointNo") int appointNo) {

		System.out.println("Appointment No:" + appointNo);
		return repo.getAppointment(appointNo);
	}

}
