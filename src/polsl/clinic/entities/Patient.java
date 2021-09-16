package polsl.clinic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "patient")
public class Patient implements Serializable{	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "lastName")
	String lastName;	
	
	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER) // EAGER wyciaga nam wszystko powiazane z pacjentem, jezeli uzyjemy LAZY to wyciaga nam tylko 
	//konkret i mozemy uzyc geterow, aczkowliek jezeli zamkniemy entity managera to dostaniemy exception, wiec wtedy by trzeba bylo ponownie otwieracamanagera
	List<Visit> visits = new ArrayList<Visit>();	

	public Patient(){}
	
	public Patient(String _name, String _lastName){
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
	
	@JsonManagedReference(value = "patient-visits")
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	} 
}
