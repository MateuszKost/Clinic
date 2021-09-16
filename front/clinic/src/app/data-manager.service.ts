import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';


export interface Patient {
  id: number;
  name: string;
  lastName: string;
  visits: Visit[];
}

export interface Doctor {
  id: number;
  name: string;
  lastName: string;
  visits: Visit[];
}

export interface Visit {
  visitId: number;
  doctorId: number;
  patientId: number;
  date: string;
  diseaseName: string;
}

@Injectable({
  providedIn: 'root'
})
export class DataManagerService {

  visits: Visit[] = []
  currentTable = "none"
  visitsEmiter: EventEmitter<any> = new EventEmitter();
  tableDetectorEmiter: EventEmitter<any> = new EventEmitter();
  constructor(
    private http: HttpClient) {
    this.http.get("http://localhost:8080/take/h2", { responseType: 'json' }).subscribe((r) => { })
  }

  // PATIENTS

  getAllPatients = () => {
    return this.http.get("http://localhost:8080/take/patients", { responseType: 'json' })
  }

  addPatient = (patient: Patient) => {
    const headers = { 'content-type': 'application/json'}
    return this.http.post<Patient>("http://localhost:8080/take/patients", patient, { headers: headers }).subscribe(result => { console.log("Posted" + JSON.stringify(result));})
    
  }

  deletePatient = (id: number) => {
    const headers = { 'content-type': 'application/json'}
    return this.http.delete("http://localhost:8080/take/patients/" + id, { headers: headers }).subscribe()
  }

  updatePatient = (id: number, name: string, lastName: string) => {
    const patient: Patient = { id: id, name: name, lastName: lastName, visits: [] }
    const headers = { 'content-type': 'application/json'}
    return this.http.put<Patient>("http://localhost:8080/take/patients/" + id, patient, { headers: headers }).subscribe()
  }

  // DOCTORS

  getAllDoctors = () => {
    return this.http.get("http://localhost:8080/take/doctors", { responseType: 'json' })
  }

  addDoctor = (doctor: Doctor) => {
    const headers = { 'content-type': 'application/json'}
    return this.http.post<Doctor>("http://localhost:8080/take/doctors", doctor, { headers: headers }).subscribe(result => { console.log("Posted" + JSON.stringify(result));})
    
  }

  deleteDoctor = (id: number) => {
    const headers = { 'content-type': 'application/json'}
    return this.http.delete("http://localhost:8080/take/doctors/" + id, { headers: headers }).subscribe()
  }

  updateDoctor = (id: number, name: string, lastName: string) => {
    const doctor: Doctor = { id: id, name: name, lastName: lastName, visits: [] }
    const headers = { 'content-type': 'application/json'}
    return this.http.put<Doctor>("http://localhost:8080/take/doctors/" + id, doctor, { headers: headers }).subscribe()
  }
}
