package polsl.clinic.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class VisitDisease {

	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "visit_id")
	Visit visit;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "disease_id")
	Disease disease;
	
	public VisitDisease(){}
	
	public VisitDisease(Visit _visit, Disease _disease){
		this.disease = _disease;
		this.visit = _visit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonBackReference(value = "visit-visitdisease")
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	@JsonBackReference(value = "disease-visitdisease")
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}	
	
}
