import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
 /* private apiUrl = 'http://localhost:8080/api/EtudiantService/findAllEtudiants';

  constructor(private http : HttpClient) {}
  getAllStudents(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }*/
}
