package polsl.clinic.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class PatientFront {

	String name;
	
	String lastName;
	
	List<VisitFront> visits = new ArrayList<VisitFront>();
	
	public PatientFront(){}
	
	public PatientFront(String name, String lastName){
		this.name = name;
		this.lastName = lastName;
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
	
	public List<VisitFront> getVisits() {
		return visits;
	}
	public void setVisits(List<VisitFront> visits) {
		this.visits = visits;
	} 
	
}
