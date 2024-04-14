// app.module.ts

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';  // Import HttpClientModule

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { FilesSubmissionComponent } from './components/files-submission/files-submission.component';
import { ValidationComponent } from './components/validation/validation.component';
import { routes } from './app.routes';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { AuthService } from './services/auth.service';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AcceuilComponent,
    FilesSubmissionComponent,
    ValidationComponent,
    WelcomeComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    RouterModule,
    HttpClientModule,  // Include HttpClientModule here
    RouterModule.forRoot(routes),
    FormsModule,
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
