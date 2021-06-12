package clinic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Visit {

	@Id
	@GeneratedValue
	int id;
	String Date; // date time of visit
	@ManyToOne
	List<VisitDisease> visits; 
	@ManyToOne
	Doctor doctor;
	@ManyToOne
	Patient patient;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public List<VisitDisease> getVisits() {
		return visits;
	}
	public void setVisits(List<VisitDisease> visits) {
		this.visits = visits;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
