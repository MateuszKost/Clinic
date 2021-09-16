import { HttpClient } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { DataManagerService, Visit } from '../data-manager.service';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.css']
})
export class VisitComponent {

  displayedColumns: string[] = ['demo-id', 'demo-doctorId', 'demo-patientId', 'demo-date', 'demo-diseaseName'];
  title = 'clinic';
  dataSource: Visit[] = [];
  currentVisit: Visit = { visitId: 0, doctorId: 0, patientId: 0, date: "", diseaseName: "" }

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {

    this.dataManagerService.visitsEmiter.subscribe((emittedVisits) => {
      this.dataSource = emittedVisits
    })
  }

  onAdd = (doctorId: string, patientId: string, date: string, diseaseName: string) => {
    console.log(doctorId)
    console.log(patientId)
    console.log(date)
    console.log(diseaseName)
  }

  onDelete = (id: string, doctorId: string, patientId: string, date: string, diseaseName: string) => {
    console.log(patientId)
    console.log(doctorId)
    console.log(id)
    console.log(date)
    console.log(diseaseName)
  }

  onUpdate = (id: string, doctorId: string, patientId: string, date: string, diseaseName: string) => {
    console.log(patientId)
    console.log(doctorId)
    console.log(id)
    console.log(date)
    console.log(diseaseName)
  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((visit) => {
      if (visit.visitId == id)
        this.currentVisit = visit
    })
  }

}