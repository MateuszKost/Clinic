package polsl.clinic.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Disease;
import polsl.clinic.entities.Patient;
import polsl.clinic.entities.PatientFront;
import polsl.clinic.entities.Visit;
import polsl.clinic.entities.VisitDisease;
import polsl.clinic.entities.VisitFront;

@Stateless
public class PatientsService {

	@EJB 
	VisitDiseaseService visitDiseaseService;
	
	@EJB 
	DiseaseService diseaseService;
	
	@PersistenceContext(name = "patient")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<PatientFront> findAll(){
		Query query = manager.createQuery("select p from Patient p");
		
		List<Patient> patients = new ArrayList<Patient>();
		List<PatientFront> patientsFront = new ArrayList<PatientFront>();
		
		List<Visit> visits = new ArrayList<Visit>();
		List<VisitFront> visitsFront = new ArrayList<VisitFront>();
		
		patients = query.getResultList();
		
		List<Disease> diseaseList = new ArrayList<Disease>();		
		diseaseList = diseaseService.findAll();
		
		List<VisitDisease> visitDiseaseList = new ArrayList<VisitDisease>();		
		visitDiseaseList = visitDiseaseService.findAll();
		
		
		for(Patient patient : patients)
		{
			visits = patient.getVisits();
			for(Visit visit : visits)
			{
				for(VisitDisease visitDisease : visitDiseaseList)
				{
					if(visitDisease.getVisit().getId() == visit.getId())
					{
						for(Disease disease : diseaseList)
						{
							if(visitDisease.getDisease().getId() == disease.getId())
							{
								visitsFront.add(new VisitFront(visit.getId(), visit.getDoctor().getId(), visit.getPatient().getId(), disease.getName(), visit.getDate()));
							}
						}
					}
				}
			}
			PatientFront frontPatient = new PatientFront();
			frontPatient.setId(patient.getId());
			frontPatient.setName(patient.getName());
			frontPatient.setLastName(patient.getLastName());
			frontPatient.setVisits(visitsFront);
			
			patientsFront.add(frontPatient);
			
		}
		//return query.getResultList();
		return patientsFront;
	}
	
	public Patient findById(int id){
		return manager.find(Patient.class, id);
	}
	
	public void add(Patient patient){		
		manager.persist(patient);
	}
	
	public void deleteById(int id){
		System.out.println("before find");
		Patient patient = findById(id);
		System.out.println("before delete");
		System.out.println("id from request " + id);
		System.out.println(patient.getId());
		if(patient != null){
			System.out.println("in delete");
			manager.remove(patient);
			System.out.println("after delete");
		}
	}
	
	public void update(Patient patient){
		if(manager.find(Patient.class, patient.getId()) != null){
			manager.merge(patient);
		}
	}
	
}
