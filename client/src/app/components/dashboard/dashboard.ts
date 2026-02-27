import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer-service';
import { PurchasedTracks } from '../../interfaces/tracks';
import { AsyncPipe } from '@angular/common';
import { AuthService } from '../../services/auth-service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { catchError, exhaustMap, Observable, of, Subject, tap } from 'rxjs';

@Component({
  selector: 'app-dashboard',
  imports: [AsyncPipe, FormsModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {
  customerService = inject(CustomerService);
  authService = inject(AuthService);
  router = inject(Router);
  // private cdr = inject(ChangeDetectorRef);

  showCreateTicketModal = false;
  allTracks$ = this.customerService.getAllTracks();
  ticketSubject: string = "";
  ticketBody: string = "";

  logout(): void {
    this.authService.logout();
    this.router.navigate(["/login"]);
  }

  createTicket(): void {
    this.showCreateTicketModal = true;

    // to pop up the modal.
    }

  private submitTrigger$ = new Subject<{subject: string, body: string }>();

  submitTriggerResult$ = this.submitTrigger$.pipe(
    exhaustMap((payload) => {
      return this.customerService.submitTicket(payload).pipe(
        tap(() => {
          this.closeTicketModal();
        }),
        catchError((err) => {
          console.log(err);
          return of(null);
        })
      )
    })
  )

  onSubmitTicket(): void {

    this.submitTrigger$.next({
      subject: this.ticketSubject, 
      body: this.ticketBody
    })
    // the detectChange() approach with changeDetectorRef
    // this.customerService.submitTicket({subject: this.ticketSubject, body: this.ticketBody})
    // .subscribe({
    //   next: () => {
    //     this.closeTicketModal();
    //     this.cdr.detectChanges();
    //  // need to implement feature for refreshing the tickets. 
    //  // use pipe(startWith(undefined), switchMap() => )
    //   },
    //   error: (err) => { 
    //     console.log(err);
    //   }
    // })

  }

  closeTicketModal(): void {
    this.showCreateTicketModal = false;
  }
}
