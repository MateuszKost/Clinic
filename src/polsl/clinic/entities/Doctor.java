package polsl.clinic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	int id;
	
	String name;
	
	String lastName;	
	
	@OneToMany(mappedBy="doctor",fetch=FetchType.EAGER) // zeby nie bylo zewizyta u tego samego lekarza niee mebedzie z nim powizanaa, i beda 2 osobne encje
	List<Visit> visits = new ArrayList<Visit>();
	
	public Doctor(){}
	
	public Doctor(String _name, String _lastName){
		this.name = _name;
		this.lastName = _lastName;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonManagedReference(value = "doctor-visit")
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	} 
}
