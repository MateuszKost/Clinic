import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DataManagerService, Patient } from '../data-manager.service';


const DATA: Patient[] = [
  { id: 1, name: 'Andrzej', lastName: 'Jaworek' },
];

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  displayedColumns: string[] = ['demo-id', 'demo-name', 'demo-lastName'];
  title = 'clinic';
  dataSource = DATA;

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {
      this.dataSource = dataManagerService.patients
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onClick = () => {

  }

  onRowClicked = (id: Number) => {
    console.log(id)
  }
}
