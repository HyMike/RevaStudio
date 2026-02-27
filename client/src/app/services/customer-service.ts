import { HttpClient } from '@angular/common/http';
import { Injectable,inject } from '@angular/core';
import { Observable } from 'rxjs';
import { PurchasedTracks } from '../interfaces/tracks';
import { TicketResponse } from '../interfaces/ticket';


const API_BASE_URL = "http://localhost:8080/api";

@Injectable({
  providedIn: 'root',
})
export class CustomerService {

  constructor(private http: HttpClient) {}

  getAllTracks(): Observable<PurchasedTracks[]>{
    return this.http.get<PurchasedTracks[]>(`${API_BASE_URL}/customer/tracks`);
  } 

  submitTicket(payload: {subject: string, body: string }): Observable<TicketResponse> {
    return this.http.post<TicketResponse>(`${API_BASE_URL}/customer/create-ticket`, payload);

  }

}
