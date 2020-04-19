 package com.fantasticfour.healthcare.healthCareApiProject;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Appointment;
import model.Doctor;
import repository.DoctorRepository;

@Path("doctors")
public class DoctorResource {

	DoctorRepository repo = new DoctorRepository(); 
	
	
	@GET  //Retrieve
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getAllDoctors() {
		
		System.out.println("All Doctors called......");
		
		
		return repo.getAllDoctors();
		
	}
	
	
	
	@GET  //Retrieve
	@Path("view/{docID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getAllDoctor(@PathParam("docID") int docID){
		
		System.out.println("Doctor ID : "+docID);
		return repo.getDoctor(docID);
		
	}
	
	
	
	@GET  //RetrieveAppo
	@Path("viewappo/{appointNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointment(@PathParam("appointNo") int appointNo){
		
		System.out.println("Appointment : "+appointNo);
		return repo.getAppointment(appointNo);
		
	}
	
	
	
	@POST  //Insert
	@Path("insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor createDoctor(Doctor d1) {
		
		System.out.println(d1);
		repo.create(d1);
		repo.createLogin(d1);
		System.out.println("Succesfully Inserted..."+d1);
		
		return d1;
	}
	
	
	
	@PUT  //Update
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor updateDoctor(Doctor d1) {
		
		if(repo.getDoctor(d1.getDocID()).getDocID()==0) { //if data is not create new data
			repo.create(d1);
			System.out.println("Succesfully created new member..."+d1);
			
		}else { //else update data
			repo.update(d1);
			//repo.updateLogin(d1);
			System.out.println("Succesfully Updated..."+d1);
		}
		
		return d1;
	}
	
	
	
	@DELETE  //Delete
	@Path("delete/{docID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Doctor deleteDoctor(@PathParam("docID") int docID) {
		
		Doctor d = repo.getDoctor(docID);
		if(d.getDocID()!=0) {
			repo.delete(docID);
			repo.deleteLogin(docID);
			System.out.println("Succesfully Deleted..."+d); 
		}
		return d;
	}
	
}
