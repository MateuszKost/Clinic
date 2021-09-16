package polsl.clinic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Visit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int id;
	
	String Date; // date time of visit
	
	@OneToMany(mappedBy="visit",fetch=FetchType.EAGER)
	List<VisitDisease> visits = new ArrayList<VisitDisease>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	Doctor doctor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	Patient patient;
		
	public Visit(){}
	
	public Visit(String _date, Patient _patient, Doctor _doctor){
			this.Date = _date;
			this.doctor = _doctor;
			this.patient = _patient;
		}
	
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
	
	@JsonIgnore
	public List<VisitDisease> getVisits() {
		return visits;
	}
	
	public void setVisits(List<VisitDisease> visits) {
		this.visits = visits;
	}
	
	@JsonBackReference(value = "doctor-visits")
	//@JsonIgnore
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@JsonBackReference(value = "patient-visits")
	//@JsonIgnore
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
