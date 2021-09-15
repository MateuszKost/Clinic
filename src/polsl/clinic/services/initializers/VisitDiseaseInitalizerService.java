package polsl.clinic.services.initializers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import polsl.clinic.entities.VisitDisease;
import polsl.clinic.entities.Visit;
import polsl.clinic.entities.Disease;

@Stateless
public class VisitDiseaseInitalizerService {

	@PersistenceContext(name="visitdisease") 
	EntityManager manager;
	
	List<VisitDisease> visitDiseases = new ArrayList<VisitDisease>();
		
	
	@SuppressWarnings("unchecked")
	public List<VisitDisease> init(List<Disease> diseases, List<Visit> visits) {
		for (Disease disease: diseases) {
			for (Visit visit: visits) {
				VisitDisease visitDisease = new VisitDisease();
				visitDisease.setVisit(visit);
				visitDisease.setDisease(disease);
				visitDiseases.add(visitDisease);
			}
		}
		for(VisitDisease visitDisease : visitDiseases){
			manager.persist(visitDisease);
		}
		
		Query query = manager.createQuery("SELECT v FROM VisitDisease v");
		this.visitDiseases = query.getResultList();
		return this.visitDiseases;
	}
	
}
