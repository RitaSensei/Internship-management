// app.module.ts

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { FilesSubmissionComponent } from './components/files-submission/files-submission.component';
import { ValidationComponent } from './components/validation/validation.component';
import { routes } from './app.routes';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from './components/welcome/welcome.component';




@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AcceuilComponent,
    FilesSubmissionComponent,
    ValidationComponent,
    WelcomeComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    RouterModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers:[HttpClient],
    
  
  bootstrap: [AppComponent]
})
export class AppModule { }
