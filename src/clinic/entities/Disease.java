package clinic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disease{

	@Id
	@GeneratedValue
	int id;
	String name;
	@OneToMany(mappedBy="disease",fetch=FetchType.EAGER)
	List<VisitDisease> visits = new ArrayList<VisitDisease>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VisitDisease> getVisits() {
		return visits;
	}
	public void setVisits(List<VisitDisease> visits) {
		this.visits = visits;
	} 
	
}
