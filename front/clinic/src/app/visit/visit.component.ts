import { HttpClient } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { DataManagerService, Visit } from '../data-manager.service';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.css']
})
export class VisitComponent {

  displayedColumns: string[] = ['demo-id', 'demo-doctorId', 'demo-patientId', 'demo-date'];
  title = 'clinic';
  dataSource: Visit[] = [];
  currentVisit: Visit = { id: 0, doctorId: 0, patientId: 0, date: "" }

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {

    this.dataManagerService.visitsEmiter.subscribe((emittedVisits) => {
      this.dataSource = emittedVisits
    })
  }

  onAdd = (doctorId: string, patientId: string) => {
    console.log(doctorId)
    console.log(patientId)
  }

  onDelete = (id: string, doctorId: string, patientId: string, date: string) => {
    console.log(patientId)
    console.log(doctorId)
    console.log(id)
    console.log(date)
  }

  onUpdate = (id: string, doctorId: string, patientId: string, date: string) => {
    console.log(patientId)
    console.log(doctorId)
    console.log(id)
    console.log(date)
  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((visit) => {
      if (visit.id == id)
        this.currentVisit = visit
    })
  }

}