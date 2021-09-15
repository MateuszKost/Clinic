package polsl.clinic.services.initializers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Doctor;

@Stateless
public class DoctorInitializerService {
	
	@PersistenceContext(name="doctor") 
	EntityManager manager;
	
	List<Doctor> doctors = new ArrayList<Doctor>();
	
	private void createDoctors(){
		this.doctors.add(new Doctor("Bartek", "Maly"));
		this.doctors.add(new Doctor("Krzysztof", "Bonk"));
		this.doctors.add(new Doctor("Anna", "Seweryn"));
	}
		
	
	@SuppressWarnings("unchecked")
	public List<Doctor> init() {
		this.createDoctors();
		for (Doctor doctor: doctors) {
			manager.persist(doctor);
		}
		Query query = manager.createQuery("SELECT d FROM Doctor d");
		this.doctors = query.getResultList();
		return this.doctors;
	}
	
}
