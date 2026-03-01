import { Component, OnInit } from '@angular/core';
import { TicketResponse } from '../../interfaces/ticket';
import { TicketService } from '../../services/ticket-service';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { TicketThread } from '../ticket-thread/ticket-thread';
import { TicketThreadModal } from '../ticket-thread-modal/ticket-thread-modal';

@Component({
  selector: 'app-ticket',
  imports: [AsyncPipe],
  templateUrl: './ticket.html',
  styleUrl: './ticket.css',
})
export class Ticket implements OnInit {

  allTickets!: Observable<TicketResponse[]>; 

  constructor(
    private ticketService: TicketService,
    private dialog: MatDialog
  ) {};

  ngOnInit(): void {
    this.allTickets = this.ticketService.getAllTickets();
  }

  openThread(ticketId: number) {
    this.dialog.open(TicketThreadModal, {
      data: { ticketId },
      width: '500px'
    });

  }


// get all the tickets to display 
// then create a button that allows you to view the tickets in a different page.  

// create a ticket service that calls the backend to retrieve all the tickets
// then you can take the observable and loop thru that. 





}
