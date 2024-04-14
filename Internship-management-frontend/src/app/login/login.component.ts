// login.component.ts
import { Component } from '@angular/core';

import {  AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [
    AuthService
],

})
export class LoginComponent {
  username: string = '';
  password: string = '';
  role: string = '';

  constructor(private authService: AuthService) {}

  onSubmit(): void {
    this.authService.login(this.username, this.password, this.role).subscribe(
      (response: any) => {
        console.log('Login successful', response);
        // Handle successful login, e.g., navigate to another page
      },
      (error: any) => {
        console.error('Login failed', error);
        // Handle login error, e.g., display an error message
      }
    );
  }}