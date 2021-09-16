package polsl.clinic.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Visit;

@Stateless
public class VisitDiseaseService {

	@PersistenceContext(name="visitdisease")
	EntityManager manager;
		
	@SuppressWarnings("unchecked")
	public List<Visit> findAll(){
		Query query = manager.createQuery("select v from VisitDisease v");
		return query.getResultList();
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
	
}
