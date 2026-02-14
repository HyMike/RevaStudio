import { Routes } from '@angular/router';
import { LoginPage } from './components/login-page/login-page';
import { Dashboard } from './components/dashboard/dashboard';

export const routes: Routes = [
    {path: 'login', component: LoginPage},
    {path: 'dashboard', component: Dashboard}
];
