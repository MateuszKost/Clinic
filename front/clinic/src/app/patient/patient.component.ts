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
    this.dataManagerService.tableDetectorEmiter.subscribe((currentTable) => {
      this.dataManagerService.currentTable = currentTable

      if (currentTable == "doctor")
        this.currentPatient = { id: 0, name: "", lastName: "", visits: [] }
    })
  }

  ngOnInit(): void {
    this.dataManagerService.getAllPatients()
      .subscribe((response) => {
        this.dataSource = <Patient[]>response
        console.log(this.dataSource)
      })
  }

  getAllPatientsAndRefresh = () => {
    this.dataManagerService.getAllPatients().subscribe((response)=>{
      this.dataSource = <Patient[]>response
      this.ngOnInit()
    })
  }

  onAdd = (lastNamee: string, namee: string) => {
    let patient: Patient = { id: 0, name: namee, lastName: lastNamee, visits: [] }
    this.dataManagerService.addPatient(patient).subscribe(result => { console.log("Posted" + JSON.stringify(result));
    this.getAllPatientsAndRefresh()
  })
    
    
  }

  onDelete = (id: string, lastName: string, name: string) => {
    this.dataManagerService.deletePatient(+id).subscribe(()=>this.getAllPatientsAndRefresh())

  }

  onUpdate = (id: string, lastName: string, name: string) => {
    this.dataManagerService.updatePatient(+id, name, lastName).subscribe(()=>this.getAllPatientsAndRefresh())
  }

  onRowClicked = (id: Number) => {
    this.dataSource.forEach((patient) => {
      if (patient.id == id)
        this.currentPatient = patient
    })
    this.dataManagerService.tableDetectorEmiter.emit("patient")
    this.dataManagerService.visitsEmiter.emit(this.currentPatient.visits)
  }
}
