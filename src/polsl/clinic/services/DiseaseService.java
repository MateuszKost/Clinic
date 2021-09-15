package polsl.clinic.services;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Disease;
import polsl.clinic.entities.Patient;

@Stateless
public class DiseaseService {

	@PersistenceContext(name="disease")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Disease> findAll(){
		Query query = manager.createQuery("select d from Disease d");
		return query.getResultList();
	}
	
	public Disease findById(int id){
		return manager.find(Disease.class, id);
	}
	
	public void add(Disease disease){
		manager.persist(disease);
	}
	
	public void deleteById(int id){
		Disease disease = findById(id);
		if(disease != null){
			manager.remove(disease);
		}
	}
	
	public void update(Disease disease){
		if(manager.find(Disease.class, disease.getId()) != null){
			manager.merge(disease);
		}
	}
		
	@SuppressWarnings("unchecked")
	public List<Disease> findDiseasesByPatientId(int patientId){
		
		if(manager.find(Patient.class, patientId) == null){
			return Collections.emptyList();
		}
		
		Query query = manager.createQuery("select d from Disease d where id = visitDisease.diseaseId join visit as v on visitId = v.id where v.patientId = " + patientId);
		return query.getResultList();
	}
}
