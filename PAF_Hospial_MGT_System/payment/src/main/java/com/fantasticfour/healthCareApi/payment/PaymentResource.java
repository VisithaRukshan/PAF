package com.fantasticfour.healthCareApi.payment;


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

import model.Payment;
import repository.PaymentRepository;

@Path("payment")
public class PaymentResource {

	PaymentRepository repo = new PaymentRepository(); 
	
	
	@GET  //Retrieve
	@Path("view/{payID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPayment(@PathParam("payID") int payID){
		
		System.out.println("Payment ID : "+payID);
		return repo.getPayment(payID);
		
	}
	
	@GET  //view all
	@Path("viewall")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayment(){
		return repo.getAllPayment();
	}
	
	
	@POST  //Insert
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment createPayment(Payment p1) {
		
		System.out.println(p1);
		repo.create(p1);
		repo.createCard(p1);
		System.out.println("Succesfully Inserted..."+p1);
		
		return p1;
	}
	
	
	
	@PUT  //Update
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment updatePayment(Payment p1) {
		
		
			repo.update(p1);
			System.out.println("Succesfully Updated..."+p1);
		
		
		return p1;
	}
	
	
	
	@DELETE  //Delete
	@Path("delete/{payID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment deletePayment(@PathParam("payID") int payID) {
		
		Payment p = repo.getPayment(payID);
		if(p.getPayID()!=0) {
			repo.delete(payID);
			System.out.println("Succesfully Deleted..."+p); 
		}
		return p;
	}
}
