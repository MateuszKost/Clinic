import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DataManagerService, Doctor } from '../data-manager.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  displayedColumns: string[] = ['demo-id', 'demo-name', 'demo-lastName'];
  title = 'clinic';
  dataSource: Doctor[] = [];
  currentDoctor: Doctor = {id: 0, name: "", lastName: "", visits: []}

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {

  }

  ngOnInit(): void {
    this.dataSource = this.dataManagerService.doctors
  }

  onAdd = () => {

  }

  onDelete = () => {

  }

  onUpdate = () => {

  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((doctor)=>{
      if(doctor.id == id)
        this.currentDoctor=doctor
    })
    
    this.dataManagerService.visitsEmiter.emit(this.currentDoctor.visits)
  }
}

