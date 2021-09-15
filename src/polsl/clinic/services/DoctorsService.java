package polsl.clinic.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Doctor;

@Stateless
public class DoctorsService {
	
	@PersistenceContext(name="doctor")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Doctor> findAll(){
		Query query = manager.createQuery("select d from Doctor d");
		return query.getResultList();
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
