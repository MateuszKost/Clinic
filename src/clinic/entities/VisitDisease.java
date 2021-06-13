package clinic.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VisitDisease {

	@Id
	@GeneratedValue
	int id;
	@ManyToOne(fetch=FetchType.LAZY)
	Visit visit;
	@ManyToOne(fetch=FetchType.LAZY)
	Disease disease;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}	
	
}
