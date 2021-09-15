import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


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

  constructor(
    private http: HttpClient) {
    this.getAllPatients()
  }

  getAllPatients = () => {
    const visits1 = [
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" }]

    const visits2 = [
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" }]

    const visits3 = [
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" },
      { id: 10, doctorId: 100, patientId: 1, date: "12.10.2137" }]

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
