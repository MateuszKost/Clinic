package polsl.clinic.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Visit;
import polsl.clinic.entities.Patient;
import polsl.clinic.entities.Doctor;

@Stateless
public class VisitsService {

	@PersistenceContext(name="visit")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Visit> findAll(){
		Query query = manager.createQuery("select v from Visit v");
		return query.getResultList();
	}
	
	public Visit findById(int id){
		return manager.find(Visit.class, id);
	}
	
	public void add(Visit visit){
		manager.persist(visit);
	}
	
	public void deleteById(int id){
		Visit visit = findById(id);
		if(visit != null){
			manager.remove(visit);
		}
	}
	
	public void update(Visit visit){
		if(manager.find(Visit.class, visit.getId()) != null){
			manager.merge(visit);
		}
	}
//		
//	@SuppressWarnings("unchecked")
//	public List<Visit> findByPatientId(int patientId){
//		
//		if(manager.find(Patient.class, patientId) == null){
//			return Collections.emptyList();
//		}
//		
//		Query query = manager.createQuery("select v from Visits v where patientId = " + patientId);
//		return query.getResultList();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Visit> findByDoctortId(int doctorId){
//		
//		if(manager.find(Doctor.class, doctorId) == null){
//			return Collections.emptyList();
//		}
//		
//		Query query = manager.createQuery("select * from visits where doctorId = " + doctorId);
//		return query.getResultList();
//	}
//	
//	public List<Visit> findAllByDate(String date){
//		List<Visit> allVisits = findAll();
//		return allVisits.stream()
//				.filter(visit -> visit.getDate().equals(date))
//				.collect(Collectors.toList());
//	}
	
	//wyzej narazie nie, moze pozniej jak sie ogarnie front
}
