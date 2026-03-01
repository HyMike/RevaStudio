import { Component, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { TicketThreadInterface } from '../../interfaces/ticket-thread-interface';
import { TicketThreadService } from '../../services/ticket-thread-service';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-ticket-thread-modal',
  imports: [AsyncPipe],
  templateUrl: './ticket-thread-modal.html',
  styleUrl: './ticket-thread-modal.css',
})
export class TicketThreadModal implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: {ticketId: number},
  private dialogRef: MatDialogRef<TicketThreadModal>,
  private ticketThreads: TicketThreadService
  ) {}

  ticketThreadMessages$!: Observable<TicketThreadInterface[]>;

  ngOnInit(): void {
      this.ticketThreadMessages$ = this.ticketThreads.getAllThreadMessages(this.data.ticketId);
  }


  onClose(): void {
    this.dialogRef.close();
  }
  

}
