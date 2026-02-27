import { Injectable } from '@angular/core';
import { TicketResponse } from '../interfaces/ticket';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


const API_BASE_URL = "http://localhost:8080/api";

@Injectable({
  providedIn: 'root',
})
export class TicketService {

  constructor(private http: HttpClient) {}

  getAllTickets(): Observable<TicketResponse[]> {
    return this.http.get<TicketResponse[]>(`${API_BASE_URL}/ticket/tickets`);
  }
  
}
