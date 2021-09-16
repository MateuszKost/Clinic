package polsl.clinic.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Patient;

@Stateless
public class PatientsService {

	@PersistenceContext(name = "patient")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Patient> findAll(){
		Query query = manager.createQuery("select p from Patient p");
		return query.getResultList();
	}
	
	public Patient findById(int id){
		return manager.find(Patient.class, id);
	}
	
	public void add(Patient patient){		
		manager.persist(patient);
	}
	
	public void deleteById(int id){
		Patient patient = findById(id);
		if(patient != null){
			manager.remove(patient);
		}
	}
	
	public void update(Patient patient){
		if(manager.find(Patient.class, patient.getId()) != null){
			manager.merge(patient);
		}
	}
	
}
