import { Routes } from '@angular/router';
import { LoginPage } from './components/login-page/login-page';
import { Dashboard } from './components/dashboard/dashboard';
import { authGuard } from './guards/auth-guard';
import { guestGuard } from './guards/guest-guard';

export const routes: Routes = [
    {path: 'login', component: LoginPage, canActivate: [guestGuard]},
    {path: 'dashboard', component: Dashboard, canActivate: [authGuard]}
];
