package hospitalPaf.hospitalPaf;

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

import model.Hospital;
import repository.HospitalRepository;


@Path("/hospitals")
public class HospitalResources
{
	
	HospitalRepository repo = new HospitalRepository(); 
	
//get method called	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getHospitals()
	{
		System.out.println("getHospital called..");	
		return repo.getHospitals();	
	}

	
	@GET
	@Path("view/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getHospital(@PathParam("id") int id)
	{
		return repo.getHospital(id);
	}
	
//post method called	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital createHospital(Hospital h1)
	{
		System.out.println(h1);
		repo.create(h1);
		
		return h1;
	}
	
//put method called	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital updateHospital(Hospital h1)
	{
		System.out.println(h1);		
		if(repo.getHospital(h1.getId()).getId()==0)
		{
			repo.create(h1);
		}
		else
		{
			repo.update(h1);
		}
		return h1;
	}
	
//delete method called	
	@DELETE
	@Path("delete/{id}")
	public Hospital deleteHospital(@PathParam("id") int id)
	{
		
		Hospital h = repo.getHospital(id);
		
		if(h.getId()!=0)
	    	repo.delete(id);
		return h;
		
	}
}
