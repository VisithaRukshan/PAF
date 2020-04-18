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
	/*@GET
	@Path("login/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient loginCheck(@PathParam("username") String username) {
		
		return repo.logincheck(username);
	}*/
		

	// get paticular patient
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

}
