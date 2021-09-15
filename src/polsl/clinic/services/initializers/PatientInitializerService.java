package polsl.clinic.services.initializers;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Patient;

@Stateless
public class PatientInitializerService {

	@PersistenceContext(name="patient") 
	EntityManager manager;
	
	List<Patient> patients = new ArrayList<Patient>();
	
	private void createPatients(){
		this.patients.add(new Patient("Artur", "Malucch"));
		this.patients.add(new Patient("Krzysztof", "Marcinak"));
		this.patients.add(new Patient("Anna", "Bal"));
		this.patients.add(new Patient("Beata", "Brzeczyk"));
		this.patients.add(new Patient("Wojtek", "Pach"));
	}
	
	@SuppressWarnings("unchecked")
	public Boolean checkPatientsExistance(){
		Query query = manager.createQuery("SELECT p FROM Patient p");
		this.patients = query.getResultList();
		return this.patients.size() > 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> init() {
		this.createPatients();
		for (Patient patient: patients) {
			manager.persist(patient);
		}
		Query query = manager.createQuery("SELECT p FROM Patient p");
		this.patients = query.getResultList();
		return this.patients;
	}
}
