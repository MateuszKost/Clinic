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

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((visit) => {
      if (visit.visitId == id)
      console.log(visit)
        this.currentVisit = visit
    })
  }

}