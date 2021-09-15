package polsl.clinic.controllers;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import polsl.clinic.entities.Visit;
import polsl.clinic.services.VisitsService;

@Path("/visits")
@Consumes({ "application/json" })
@Produces({ "appliaction/json" })
public class VisitsController {
	
	@EJB 
	private VisitsService visitsService;
	
	@GET
	public Response getAll() {				
		
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(visitsService.findAll())
				.build();
	}
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id){	
		Visit visit= visitsService.findById(id);
		if(visit == null){
			return Response
					.status(404)
					.header("Access-Control-Allow-Origin", "*")
					.type(MediaType.APPLICATION_JSON)
					.entity("Patient doesn't exist")
					.build();
		}
		
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(visit)
				.build();
		
	}
	
	@POST
	public Response addPatient(Visit visit){
		
		visitsService.add(visit);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletePatient(@PathParam("id") int id){
		
		visitsService.deleteById(id);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/patient")
	public Response updatePatient(@PathParam("id") int id, Visit visit){
		visit.setId(id);
		visitsService.update(visit);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
