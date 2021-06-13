package clinic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import clinic.entities.Disease;
import clinic.entities.Doctor;
import clinic.entities.Patient;
import clinic.entities.Visit;
import clinic.entities.VisitDisease;

public class TestVisit {

public static void main(String[] args) {
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("clinic");
	EntityManager manager = managerFactory.createEntityManager(); 
	manager.getTransaction().begin();
	
	Patient patient = new Patient();
	patient.setName("Adam");
	patient.setLastName("Ryba");	
	manager.persist(patient);
	
	Doctor doctor = new Doctor();
	doctor.setName("Andrzej");
	doctor.setLastName("Brzeczyszczykiewicz");	
	manager.persist(doctor);
	
	Disease disease = new Disease();
	disease.setName("katar");
	manager.persist(disease);
	
	Visit visit = new Visit();
	visit.setDate("1 lipiec 2021");	
	visit.setDoctor(doctor);
	visit.setPatient(patient);
	manager.persist(visit);
	
	VisitDisease visits = new VisitDisease();
	visits.setDisease(disease);
	visits.setVisit(visit);
	manager.persist(visits);
	
	
	//tworzymy wizyte, tworzymy doktora i pacjenta, wysylamy doktora i apcejtna ndo bazy, przypisujemy och do wizyty, wpisujemy wozte do bazy
	
	
	manager.getTransaction().commit();
	manager.close();
	managerFactory.close();	
}
}
