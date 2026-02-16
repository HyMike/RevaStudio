import { HttpInterceptorFn } from '@angular/common/http';
import { JwtStorage } from '../services/jwt-storage';
import { inject } from '@angular/core';

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {
  const jwtStorage = inject(JwtStorage);
  const jwtToken = jwtStorage.getToken();


  if (jwtToken) {
    req = req.clone({
      setHeaders: { Authorization: `Bearer ${jwtToken}`},
    })
  }
  
  return next(req);
};
