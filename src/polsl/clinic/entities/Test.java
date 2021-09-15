package polsl.clinic.entities;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/start")
public class Test {

	@GET
	public String test()
	{
		return "Ala";
	}
}
