import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnrolleeService {

  private baseUrl = 'http://localhost:8080/api/v1/enrollees';

  constructor(private http: HttpClient) { }

  getEnrolleeList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getEnrolleeById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/enrollee` + `/${id}`);
  }

  getEnrolleesByStatus(status: boolean): Observable<any> {
    return this.http.get(`${this.baseUrl}` + `/${status}`);
  }

  createEnrollee(enrollee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/create`, enrollee);
  }

  updateEnrollee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/${id}`, value);
  }

  deleteEnrollee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/${id}`, { responseType: 'text'});
  }

  deleteAllEnrollees(): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete`, {responseType: 'text'});
  }

}
