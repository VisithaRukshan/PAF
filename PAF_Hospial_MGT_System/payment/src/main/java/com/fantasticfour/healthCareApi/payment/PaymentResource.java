package com.fantasticfour.healthCareApi.payment;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		
		if(repo.getPayment(p1.getPayID()).getPayID()==0) { //if data is not create new data
			repo.create(p1); 
			System.out.println("Succesfully created new member..."+p1);
			
		}else { //else update data
			repo.update(p1);
			System.out.println("Succesfully Updated..."+p1);
		}
		
		return p1;
	}
	
	
	
	@DELETE  //Delete
	@Path("delete/{payID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Payment deletePayment(@PathParam("payID") int payID) {
		
		Payment p = repo.getPayment(payID);
		if(p.getPayID()!=0) {
			repo.delete(payID);
			repo.deleteCard(payID);
			System.out.println("Succesfully Deleted..."+p); 
		}
		return p;
	}
}
