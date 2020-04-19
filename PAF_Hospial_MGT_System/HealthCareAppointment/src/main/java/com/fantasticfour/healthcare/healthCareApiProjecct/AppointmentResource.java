package com.fantasticfour.healthcare.healthCareApiProjecct;

import java.util.Arrays;
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
import repository.AppointmentRepositary;


@Path("/appointments")
public class AppointmentResource {
	
	AppointmentRepositary repo = new AppointmentRepositary();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAllAppointments()
	{
		System.out.println("All called......");
		
		return repo.getAllAppointments();
	}
	
	@GET
	@Path("view/{appointNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointment(@PathParam("appointNo") int appointNo)
	{
		
		System.out.println("Appointment No:"+appointNo);
		return repo.getAppointment(appointNo);
	}
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
		public Appointment createAppointment(Appointment A1) 
		{
	System.out.println(A1);
	repo.create(A1);
		
		return A1;
	}
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
		public Appointment updateAppointment(Appointment A1) 
		{
	System.out.println(A1);
	if(repo.getAppointment(A1.getAppointNo()).getAppointNo()==0)
	{
		repo.create(A1);
	}
	else
	{
		repo.update(A1);
	}	
		return A1;
	}
	@DELETE
	@Path("delete/{appointNo}")
	public Appointment deleteAppointment(@PathParam("appointNo") int appointNo)
		{
			Appointment A1 = repo.getAppointment(appointNo);
			
			if(A1.getAppointNo()!=0)
			repo.delete(appointNo);
			return A1;
		}
			
	
}