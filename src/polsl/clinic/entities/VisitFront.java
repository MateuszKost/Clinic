package polsl.clinic.entities;

public class VisitFront {

	int visitId;
	
	int doctorId;
	 
	int patientId;
	
	String diseaseName;
	
	String date;
	
	public VisitFront(int _visitId, int _doctorId, int _patientId, String _diseaseName, String _date)
	{
		this.visitId = _visitId;
		this.doctorId = _doctorId;
		this.patientId = _patientId;
		this.diseaseName = _diseaseName;
		this.date = _date;
	}
	
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int id) {
		this.visitId = id;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int id) {
		this.doctorId = id;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int id) {
		this.patientId = id;
	}
	
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String name) {
		this.diseaseName = name;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String name) {
		this.date = name;
	}
	
}
