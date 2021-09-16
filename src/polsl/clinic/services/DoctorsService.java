package polsl.clinic.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Disease;
import polsl.clinic.entities.Doctor;
import polsl.clinic.entities.DoctorFront;
import polsl.clinic.entities.Patient;
import polsl.clinic.entities.PatientFront;
import polsl.clinic.entities.Visit;
import polsl.clinic.entities.VisitDisease;
import polsl.clinic.entities.VisitFront;

@Stateless
public class DoctorsService {
	
	@EJB 
	VisitDiseaseService visitDiseaseService;
	
	@EJB 
	DiseaseService diseaseService;
	
	@PersistenceContext(name="doctor")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<DoctorFront> findAll(){
		Query query = manager.createQuery("select d from Doctor d");		
		
		List<Doctor> doctors = new ArrayList<Doctor>();
		List<DoctorFront> doctorsFront = new ArrayList<DoctorFront>();
		
		List<Visit> visits = new ArrayList<Visit>();
		List<VisitFront> visitsFront = new ArrayList<VisitFront>();
		
		doctors = query.getResultList();
		
		List<Disease> diseaseList = new ArrayList<Disease>();		
		diseaseList = diseaseService.findAll();
		
		List<VisitDisease> visitDiseaseList = new ArrayList<VisitDisease>();		
		visitDiseaseList = visitDiseaseService.findAll();
		
		
		for(Doctor doctor: doctors)
		{
			visits = doctor.getVisits();
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
			DoctorFront frontDoctor = new DoctorFront();
			frontDoctor.setId(doctor.getId());
			frontDoctor.setName(doctor.getName());
			frontDoctor.setLastName(doctor.getLastName());
			frontDoctor.setVisits(visitsFront);
			
			doctorsFront.add(frontDoctor);
			
		}
		//return query.getResultList();
		return doctorsFront;
	}
	
	public Doctor findById(int id){
		return manager.find(Doctor.class, id);
	}
	
	public void add(Doctor doctor){
		manager.persist(doctor);
	}
	
	public void deleteById(int id){
		Doctor doctor = findById(id);
		if(doctor != null){
			manager.remove(doctor);
		}
	}
	
	public void update(Doctor doctor){
		if(manager.find(Doctor.class, doctor.getId()) != null){
			manager.merge(doctor);
		}
		
	}
}
