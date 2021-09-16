package polsl.clinic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Stateful
@Entity
public class Disease{

	@Id
	@GeneratedValue
	@Column(name = "disease_id")
	int id;
	
	@Column(name = "disease_name")
	String name;
	
	@OneToMany(mappedBy="disease",fetch=FetchType.EAGER)
	List<VisitDisease> visits = new ArrayList<VisitDisease>();
	
	public Disease(){}
	
	public Disease(String _name){
		this.name = _name;
	}
		
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
