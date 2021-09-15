import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


export interface Patient {
  id: number;
  name: string;
  lastName: string;
}

@Injectable({
  providedIn: 'root'
})
export class DataManagerService {

  patients : Patient[] = []
  constructor(
    private http: HttpClient){
      this.getAllPatients()
    }

  getAllPatients = () => {
    
    const response = [//this.http.get("http://localhost:8080/clinic/patients", { responseType: 'json' }).subscribe((res) => console.log(res))
      { id: 1, lastName: "Kowalski", name: "Adam" },
      { id: 2, lastName: "Nowak", name: "Zbigniew" },
      { id: 3, lastName: "Biedny", name: "Jan" }] 

    this.patients = response
  }


}
