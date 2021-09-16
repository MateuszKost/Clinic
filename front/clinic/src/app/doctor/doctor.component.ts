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
  currentDoctor: Doctor = { id: 0, name: "", lastName: "", visits: [] }

  constructor(private http: HttpClient,
    private dataManagerService: DataManagerService) {
    this.dataManagerService.tableDetectorEmiter.subscribe((currentTable)=>{
      this.dataManagerService.currentTable=currentTable

      if(currentTable == "patient")
        this.currentDoctor = { id: 0, name: "", lastName: "", visits: [] }
    })
  }

  ngOnInit(): void {
    this.dataManagerService.getAllDoctors()
    .subscribe((response) => {
      this.dataSource = <Doctor[]>response
      console.log(this.dataSource)
    })
  }

  getAllDoctorsAndRefresh = () => {
    this.dataManagerService.getAllDoctors().subscribe((response)=>{
      this.dataSource = <Doctor[]>response
      this.ngOnInit()
    })
  }

  onAdd = (lastNamee: string, namee: string) => {
    let Doctor: Doctor = { id: 0, name: namee, lastName: lastNamee, visits: [] }
    this.dataManagerService.addDoctor(Doctor).subscribe(result => { console.log("Posted" + JSON.stringify(result));
    this.getAllDoctorsAndRefresh()})
    
  }

  onDelete = (id: string, lastName: string, name: string) => {
    this.dataManagerService.deleteDoctor(+id).subscribe(()=>  this.getAllDoctorsAndRefresh())
  
  }

  onUpdate = (id: string, lastName: string, name: string) => {
    this.dataManagerService.updateDoctor(+id, name, lastName).subscribe(()=>  this.getAllDoctorsAndRefresh())
  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((doctor) => {
      if (doctor.id == id)
        this.currentDoctor = doctor
    })
    this.dataManagerService.tableDetectorEmiter.emit("doctor")
    this.dataManagerService.visitsEmiter.emit(this.currentDoctor.visits)
  }
}

