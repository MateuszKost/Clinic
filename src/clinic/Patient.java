package clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	
	//adnotacje dajemy albo przy geterachm albo przy samych inicjalizacjach, wazne by wszedzie bylo jednolicie

	int Id;
	String Name;
	String LastName;
	int DiseaseId;
	
	@Id
	@GeneratedValue
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	@Column(name="DiseaseId", nullable=false)
	public int getDiseaseId() {
		return DiseaseId;
	}
	public void setDiseaseId(int DiseaseId) {
		this.DiseaseId = DiseaseId;
	}
	
	Disease Disease;
	@OneToOne
	public Disease getDisease() {
		return Disease;
	}
	public void setDisease(Disease Disease) {
		this.Disease = Disease;
	}
	
	Visit Visits;
	@OneToMany
	public Visit getVisit() {
		return Visits;
	}
	public void setVisit(Visit Visits) {
		this.Visits = Visits;
	}
}
