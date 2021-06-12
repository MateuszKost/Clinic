package clinic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disease{

	@Id
	@GeneratedValue
	int id;
	String name;
	@ManyToOne
	List<VisitDisease> visits;
	
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
