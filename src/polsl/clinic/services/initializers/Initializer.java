package polsl.clinic.services.initializers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import polsl.clinic.entities.Disease;
import polsl.clinic.entities.Doctor;
import polsl.clinic.entities.Patient;
import polsl.clinic.entities.Visit;
import polsl.clinic.entities.VisitDisease;

@Stateless
public class Initializer {

	@EJB
	PatientInitializerService patientInitializerService;
	
	@EJB
	DoctorInitializerService doctorInitializerService;
	
	@EJB
	VisitInitializerService visitInitializerService;
	
	@EJB
	DiseaseInitializerService diseaseInitializerService;
	
	@EJB
	VisitDiseaseInitalizerService visitDiseaseInitalizerService;
	
	List<Patient> patientList = new ArrayList<Patient>();
	
	List<Doctor> doctorList = new ArrayList<Doctor>();
	
	List<Visit> visitList = new ArrayList<Visit>();
	
	List<Disease> diseaseList = new ArrayList<Disease>();
	
	List<VisitDisease> visitDiseaseList = new ArrayList<VisitDisease>();
	
	private Boolean verifyDataInit() {
		return !this.patientInitializerService.checkPatientsExistance();
	}
	
	public String initializeData() {
		try { 
			if (this.verifyDataInit()) {
				this.patientList = this.patientInitializerService.init();
				this.doctorList = this.doctorInitializerService.init();
				this.visitList = this.visitInitializerService.init(patientList, doctorList);
				this.diseaseList = this.diseaseInitializerService.init();
				this.visitDiseaseList = this.visitDiseaseInitalizerService.init(diseaseList, visitList);
				return "Data initialized";
			}
			return "Data exists! - Restart server to reinit";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
