package polsl.clinic.controllers;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import polsl.clinic.entities.Patient;
import polsl.clinic.services.PatientsService;

@Path("/patients")
@Consumes({ "application/json" })
@Produces({ "appliaction/json" })
public class PatientsController {
	
	@EJB
	private PatientsService patientsService;
	
	@OPTIONS
	public Response options() {
	    return Response.ok("")
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .build();
	}
	
	@GET
	public Response getAll() {				
		
		return Response
				.ok()
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(patientsService.findAll())
				.build();
	}
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id){	
		Patient patient = patientsService.findById(id);
		if(patient == null){
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
				.entity(patient)
				.build();
		
	}
	
	@POST
	public Response addPatient(Patient patient){
		
		patientsService.add(patient);
		return Response
				.ok()
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(patient)
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletePatient(@PathParam("id") int id){
		
		patientsService.deleteById(id);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updatePatient(@PathParam("id") int id, Patient patient){
		patient.setId(id);
		patientsService.update(patient);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
}
