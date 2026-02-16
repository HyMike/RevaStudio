import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtStorage } from '../services/jwt-storage';

export const authGuard: CanActivateFn = (route, state) => {
  const jwtStorage = inject(JwtStorage);
  const jwtToken = jwtStorage.getToken();
  const router = inject(Router);

  if (jwtToken) {
    return true;
  }

  return router.createUrlTree(["/login"]);

};
