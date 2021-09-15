import { HttpClient } from '@angular/common/http';
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
  id: number;
  doctorId: number;
  patientId: number;
  date: string;
}

@Injectable({
  providedIn: 'root'
})
export class DataManagerService {

  patients: Patient[] = []
  doctors: Doctor[] = []
  visits: Visit[] = []
  currentTable = "none"
  visitsEmiter: EventEmitter<any> = new EventEmitter();
  tableDetectorEmiter: EventEmitter<any> = new EventEmitter();
  constructor(
    private http: HttpClient) {
    this.getAllPatients()
  }

  getAllPatients = () => {
    const visits1 = [
      { id: 10, doctorId: 1400, patientId: 1, date: "12.10.2137" },
      { id: 20, doctorId: 2700, patientId: 1, date: "12.10.2137" },
      { id: 30, doctorId: 30240, patientId: 1, date: "12.10.2137" },
      { id: 40, doctorId: 41200, patientId: 1, date: "12.10.2137" }]

    const visits2 = [
      { id: 10, doctorId: 10313210, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 1321132100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 12, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 1100, patientId: 1, date: "12.10.2137" }]

    const visits3 = [
      { id: 14450, doctorId: 13112300, patientId: 11, date: "12.10.2137" },
      { id: 312, doctorId: 131200, patientId: 131, date: "12.10.2137" },
      { id: 10, doctorId: 15100, patientId: 12, date: "12.10.2137" },
      { id: 1510, doctorId: 16600, patientId: 3211, date: "12.10.2137" }]

    const doctors = [
      { id: 1, lastName: "Gołek", name: "Brandon", visits: visits1 },
      { id: 2, lastName: "Kost", name: "Mateusz", visits: visits2 },
      { id: 3, lastName: "Czerwiec", name: "Krzysztof", visits: visits3 }
    ]

    const response = [//this.http.get("http://localhost:8080/clinic/patients", { responseType: 'json' }).subscribe((res) => console.log(res))
      { id: 1, lastName: "Kowalski", name: "Adam", visits: visits1 },
      { id: 2, lastName: "Nowak", name: "Zbigniew", visits: visits2 },
      { id: 3, lastName: "Biedny", name: "Jan", visits: visits3 }]

    this.patients = response
    this.doctors = doctors
  }


}
