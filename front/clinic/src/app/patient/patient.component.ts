import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DataManagerService, Patient } from '../data-manager.service';


@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  displayedColumns: string[] = ['demo-id', 'demo-name', 'demo-lastName'];
  title = 'clinic';
  dataSource: Patient[] = [];
  currentPatient: Patient = {id: 0, name: "", lastName: ""}

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {
      this.dataSource = dataManagerService.patients
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onAdd = () => {

  }

  onDelete = () => {

  }

  onUpdate = () => {

  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((patient)=>{
      if(patient.id == id)
        this.currentPatient=patient
    })
  }
}
