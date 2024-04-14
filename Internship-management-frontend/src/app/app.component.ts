import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { FilesSubmissionComponent } from './components/files-submission/files-submission.component';
import { ValidationComponent } from './components/validation/validation.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { AuthService } from './services/auth.service';



@Component({
  selector: 'app-root',
  standalone: true,
  
  imports: [CommonModule, RouterOutlet,NavBarComponent,AcceuilComponent,FilesSubmissionComponent,ValidationComponent,WelcomeComponent],
  
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers:[AuthService] ,
})
export class AppComponent {
  title = 'Internship-management-frontend';
}
