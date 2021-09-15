package polsl.clinic.controllers;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import polsl.clinic.services.initializers.Initializer;

@Path("/h2")
@Consumes({ "application/json" })
@Produces({ "text/plain" })
public class DataInitializer {

	@EJB
	Initializer initializer;
	
	@GET
	public String setData() {
		return initializer.initializeData();
	}
	
}
