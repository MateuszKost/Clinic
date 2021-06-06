package clinic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Visit {

	int Id;
	String DoctorName;
	String PatientName;
	int DiseaseId;
	String Date; // date time of visit
	
	@Id
	@GeneratedValue
	public int getId() {
		return Id;
	}
	
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String DoctorName) {
		this.DoctorName = DoctorName;
	}
	
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String PatientName) {
		this.PatientName = PatientName;
	}
	
	public int getDiseaseId() {
		return DiseaseId;
	}
	public void setDiseaseId(int DiseaseId) {
		this.DiseaseId = DiseaseId;
	}
	
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	
	Disease Disease;
	@ManyToMany
	public Disease getDisease() {
		return Disease;
	}
	public void setDisease(Disease Disease) {
		this.Disease = Disease;
	}
}
