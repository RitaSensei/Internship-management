// login.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';  // Correct import statement

import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private authService: AuthService, private router: Router) {}  // Fix the parenthesis here

  login(username: string, password: string): void {
    // Call authentication service to perform login
    this.authService.login(username, password);
    this.router.navigate(['/accueil']);
  }
}
