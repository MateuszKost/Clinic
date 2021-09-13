import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface PeriodicElement {
  id: number;
  name: string;
  surname: string;
}

const DATA: PeriodicElement[] = [
  {id: 1, name: 'Andrzej', surname: 'Jaworek'},
  {id: 2, name: 'Zbigniew', surname: 'Stonoga'},
  {id: 3, name: 'Mareczek', surname: 'Heheczek'},
  {id: 4, name: 'Mateusz', surname: 'Szary'},
  {id: 5, name: 'Jas', surname: 'Fasola'},
  {id: 6, name: 'Anielka', surname: 'Mirabelka'},

];
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  displayedColumns: string[] = ['demo-id', 'demo-name', 'demo-surname'];
  title = 'clinic';
  dataSource = DATA;
  
  constructor(private http: HttpClient) { }

  onClick = () =>{
    console.log("test button clicked")
    const response = this.http.get("http://localhost:8080/clinic/test/123", {responseType: 'json'}).subscribe((res)=> console.log(res))
    console.log(response)
  }

  onRowClicked = (id: Number) =>{
    console.log(id)
  }
}
