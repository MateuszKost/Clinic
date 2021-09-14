import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

export interface PeriodicElement {
  id: number;
  name: string;
  surname: string;
}

const DATA: PeriodicElement[] = [
  { id: 1, name: 'Andrzej', surname: 'Jaworek' },
  { id: 2, name: 'Zbigniew', surname: 'Stonoga' },
  { id: 3, name: 'Mareczek', surname: 'Heheczek' },
  { id: 4, name: 'Mateusz', surname: 'Szary' },
  { id: 5, name: 'Jas', surname: 'Fasola' },
  { id: 6, name: 'Anielka', surname: 'Mirabelka' },

];

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  displayedColumns: string[] = ['demo-id', 'demo-name', 'demo-surname'];
  title = 'clinic';
  dataSource = DATA;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onClick = () => {
    console.log("test button clicked")
    const response = this.http.get("http://localhost:8080/clinic/test/123", { responseType: 'json' }).subscribe((res) => console.log(res))
    console.log(response)
  }

  onRowClicked = (id: Number) => {
    console.log(id)
  }
}
