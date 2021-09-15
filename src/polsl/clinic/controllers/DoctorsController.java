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

import polsl.clinic.entities.Doctor;
import polsl.clinic.services.DoctorsService;


@Path("/doctors")
@Consumes({ "application/json" })
@Produces({ "appliaction/json" })
public class DoctorsController {
	
	@EJB
	private DoctorsService doctorsService;
	
	@GET
	public Response getAll() {		
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(doctorsService.findAll())
				.build();
	}
	
	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id){
		Doctor doctor = doctorsService.findById(id);
		if(doctor == null){
			return Response
					.status(404)
					.header("Access-Control-Allow-Origin", "*")
					.type(MediaType.APPLICATION_JSON)
					.entity("Doctor doesn't exist")
					.build();
		}
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(doctor)
				.build();
	}
	
	@POST
	public Response addDoctor(Doctor doctor){
		doctorsService.add(doctor);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteDoctor(@PathParam("id") int id){
		doctorsService.deleteById(id);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateDoctor(@PathParam("id") int id, Doctor doctor){
		doctor.setId(id);
		doctorsService.update(doctor);
		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.type(MediaType.APPLICATION_JSON)
				.entity(doctorsService.findById(id))
				.build();
	}
	
}
