import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DataManagerService, Visit } from '../data-manager.service';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.css']
})
export class VisitComponent implements OnInit {

  displayedColumns: string[] = ['demo-id', 'demo-doctorId', 'demo-patientId', 'demo-date'];
  title = 'clinic';
  dataSource: Visit[] = [];
  currentVisit: Visit = { id: 0, doctorId: 0, patientId: 0, date: "no date" }

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {
  }

  ngOnInit(): void {
    // this.dataSource = this.dataManagerService.patients
  }

  onAdd = () => {

  }

  onDelete = () => {

  }

  onUpdate = () => {

  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((patient) => {
      if (patient.id == id)
        this.currentVisit = patient
    })
  }

}