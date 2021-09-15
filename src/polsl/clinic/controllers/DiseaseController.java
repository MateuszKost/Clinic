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

import polsl.clinic.entities.Disease;
import polsl.clinic.services.DiseaseService;

@Path("/diseases")
@Consumes({ "application/json" })
@Produces({ "appliaction/json" })
public class DiseaseController {
	
	@EJB
	private DiseaseService diseaseService;
	
	@GET
	public Response getAll() {
					
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(diseaseService.findAll())
				.build();
	}
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id){
		
		Disease disease = diseaseService.findById(id);
		if(disease == null){
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
				.entity(disease)
				.build();
		
	}
	
	@POST
	public Response addDisease(Disease disease){
		
		diseaseService.add(disease);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteDisease(@PathParam("id") int id){
		
		diseaseService.deleteById(id);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/patient")
	public Response updateDisease(@PathParam("id") int id, Disease disease){
		disease.setId(id);
		diseaseService.update(disease);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/patient/{patientId}")
	public Response getAllByPatientId(@PathParam("patientId") int patientId){
		return Response
			.status(200)
			.header("Access-Control-Allow-Origin", "*")
			.type(MediaType.APPLICATION_JSON)
			.entity(diseaseService.findDiseasesByPatientId(patientId))
			.build();
	}
	
}
