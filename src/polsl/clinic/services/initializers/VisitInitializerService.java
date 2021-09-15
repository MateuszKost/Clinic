package polsl.clinic.services.initializers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Patient;
import polsl.clinic.entities.Visit;
import polsl.clinic.entities.Doctor;

@Stateless
public class VisitInitializerService {
	
	@PersistenceContext(name="visit") 
	EntityManager manager;
	
	List<Visit> visits= new ArrayList<Visit>();
		
	@SuppressWarnings("unchecked")
	public List<Visit> init(List<Patient> patients, List<Doctor> doctors) {
		//this.createVisit();
		for (Patient patient: patients) {
			for (Doctor doctor: doctors) {
				manager.persist(new Visit("2021-08-08", patient, doctor));			
			}
		}
			
		Query query = manager.createQuery("SELECT v FROM Visit v");
		this.visits = query.getResultList();
		return this.visits;
	}
}
