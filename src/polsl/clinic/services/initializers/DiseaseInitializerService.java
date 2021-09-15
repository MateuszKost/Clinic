package polsl.clinic.services.initializers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.Disease;

@Stateless
public class DiseaseInitializerService {
	
	@PersistenceContext(name="disease") 
	EntityManager manager;	
	
	List<Disease> diseases = new ArrayList<Disease>();
	
	private void createDoctors(){
		this.diseases.add(new Disease("Covid"));
		this.diseases.add(new Disease("Rozyczka"));
		this.diseases.add(new Disease("Tulipan"));
	}
		
	
	@SuppressWarnings("unchecked")
	public List<Disease> init() {
		this.createDoctors();
		for (Disease disease: diseases) {
			manager.persist(disease);
		}
		Query query = manager.createQuery("SELECT d FROM Doctor d");
		this.diseases = query.getResultList();
		return this.diseases;
	}
}
