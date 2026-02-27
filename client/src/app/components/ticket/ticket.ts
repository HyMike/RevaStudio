import { Component, OnInit } from '@angular/core';
import { TicketResponse } from '../../interfaces/ticket';
import { TicketService } from '../../services/ticket-service';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-ticket',
  imports: [AsyncPipe],
  templateUrl: './ticket.html',
  styleUrl: './ticket.css',
})
export class Ticket implements OnInit {

  allTickets!: Observable<TicketResponse[]>; 

  constructor(
    private ticketService: TicketService
  ) {};

  ngOnInit(): void {
    this.allTickets = this.ticketService.getAllTickets();
  }




  

// get all the tickets to display 
// then create a button that allows you to view the tickets in a different page.  

// create a ticket service that calls the backend to retrieve all the tickets
// then you can take the observable and loop thru that. 





}
