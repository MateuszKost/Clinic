package polsl.clinic.controllers;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import polsl.clinic.services.VisitDiseaseService;

@Path("/visitDisease")
@Consumes({ "application/json" })
@Produces({ "appliaction/json" })
public class VisitDiseaseController {

	@EJB 
	private VisitDiseaseService visitDiseaseService;
	
	@GET
	public Response getAll() {				
		
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(visitDiseaseService.findAll())
				.build();
	}
	
}
