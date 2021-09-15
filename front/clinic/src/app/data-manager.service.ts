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
  id: number;
  doctorId: number;
  patientId: number;
  date: string;
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

  getAllPatients = () => {
    return this.http.get("http://localhost:8080/take/patients", { responseType: 'json' })
  }

  getAllDoctors = () => {
    return this.http.get("http://localhost:8080/take/doctors", { responseType: 'json' })
  }

  addPatient = (lastName: string, name: string) => {
    console.log("here")
    return this.http.post<any>("http://localhost:8080/take/patients",{ lastName: lastName, name: name } )
  }
}
