package polsl.clinic.entities;

import java.util.ArrayList;
import java.util.List;

public class DoctorFront {

	int id;
	
	String name;
	
	String lastName;
	
	List<VisitFront> visits = new ArrayList<VisitFront>();
	
	public DoctorFront(){}
	
	public DoctorFront(String name, String lastName)
	{
		this.name = name;
		this.lastName = lastName;
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
	
	public List<VisitFront> getVisits() {
		return visits;
	}
	public void setVisits(List<VisitFront> visits) {
		this.visits = visits;
	} 
	
}
