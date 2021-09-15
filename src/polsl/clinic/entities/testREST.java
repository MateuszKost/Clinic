package polsl.clinic.entities;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/test")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class testREST implements Itest {
	
	@EJB
	testEJB test;
	
	@Override
	@GET
    @Path("/{amount}")
	public String getAmount(@PathParam("amount") double amount) {
		test.setAmount(amount);
		double x = test.getAmount();
		
		return "jestesmy w klinice " + x;
	}
	
	
}
