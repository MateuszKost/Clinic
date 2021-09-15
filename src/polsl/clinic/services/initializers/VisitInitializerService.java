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
	
	private void createVisit(){
		this.visits.add(new Visit("2021-08-08"));
	}
	
	private void addPatientToVisit(Patient patient)
	{
		for(Visit visit : visits)
		{
			visit.setPatient(patient);
		}
	}
	
	private void addDoctorToVisit(Doctor doctor)
	{
		for(Visit visit : visits)
		{
			visit.setDoctor(doctor);
		}
	}
		
	@SuppressWarnings("unchecked")
	public List<Visit> init(List<Patient> patients, List<Doctor> doctors) {
		this.createVisit();
		for (Patient patient: patients) {
			this.addPatientToVisit(patient);
		}
		for (Doctor doctor: doctors) {
			this.addDoctorToVisit(doctor);
		}
		for(Visit visit: visits){
			manager.persist(visit);
		}		
		Query query = manager.createQuery("SELECT v FROM Visit v");
		this.visits = query.getResultList();
		return this.visits;
	}
}
