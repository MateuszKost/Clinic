package clinic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {	

	@Id
	@GeneratedValue
	int id;
	String name;
	String lastName;	
	@OneToMany(mappedBy="patient",fetch=FetchType.EAGER) // EAGER wyciaga nam wszystko powiazane z pacjentem, jezeli uzyjemy LAZY to wyciaga nam tylko 
	//konkret i mozemy uzyc geterow, aczkowliek jezeli zamkniemy entity managera to dostaniemy exception, wiec wtedy by trzeba bylo ponownie otwieracamanagera
	List<Visit> visits = new ArrayList<Visit>();
	
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
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	} 
}
