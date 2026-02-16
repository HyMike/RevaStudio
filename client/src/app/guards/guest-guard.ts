import { CanActivateFn, Router } from '@angular/router';
import { JwtStorage } from '../services/jwt-storage';
import { inject } from '@angular/core';

export const guestGuard: CanActivateFn = (route, state) => {
  const jwtStorage = inject(JwtStorage);
  const jwtToken = jwtStorage.getToken();
  const router = inject(Router);

  if (!jwtToken){
    return true;
  }

  return router.createUrlTree(["/dashboard"]);

};
