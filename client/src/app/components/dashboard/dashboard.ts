import { Component, inject, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer-service';
import { PurchasedTracks } from '../../interfaces/tracks'; 
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [AsyncPipe],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {
  customerService = inject(CustomerService);

  allTracks$ = this.customerService.getAllTracks();

}
