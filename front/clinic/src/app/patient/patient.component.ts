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
  currentPatient: Patient = { id: 0, name: "", lastName: "", visits: [] }

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {
  }

  ngOnInit(): void {
    this.dataSource = this.dataManagerService.patients
  }

  onAdd = (lastName: string, name: string) => {
    console.log(lastName)
    console.log(name)
  }

  onDelete = (id: string, lastName: string, name: string) => {
    console.log(id)
    console.log(lastName)
    console.log(name)
  }

  onUpdate = (id: string, lastName: string, name: string) => {
    console.log(id)
    console.log(lastName)
    console.log(name)
  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((patient) => {
      if (patient.id == id)
        this.currentPatient = patient
    })

    this.dataManagerService.visitsEmiter.emit(this.currentPatient.visits)
  }
}
