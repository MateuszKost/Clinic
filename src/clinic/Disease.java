package clinic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Disease{

	int Id;
	String Name;
	
	@Id
	@GeneratedValue
	public int getId() {
		return Id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String DiseaseName) {
		this.Name = DiseaseName;
	}
	
	Visit Visits;
	@ManyToMany
	public Visit getVisit() {
		return Visits;
	}
	public void setVisit(Visit Visits) {
		this.Visits = Visits;
	}
	
}
