import { HttpClient } from '@angular/common/http';
import { Injectable,inject } from '@angular/core';
import { Observable } from 'rxjs';
import { PurchasedTracks } from '../interfaces/tracks';


const API_BASE_URL = "http://localhost:8080/api";

@Injectable({
  providedIn: 'root',
})
export class CustomerService {

  constructor(private http: HttpClient) {}

  getAllTracks(): Observable<PurchasedTracks[]>{
    return this.http.get<PurchasedTracks[]>(`${API_BASE_URL}/customer/tracks`);
  } 

}
