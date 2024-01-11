import { Routes } from '@angular/router';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import {NavBarComponent} from "./components/nav-bar/nav-bar.component";
import {LoginComponent} from "./login/login.component";
import { FilesSubmissionComponent } from './components/files-submission/files-submission.component';
import { ValidationComponent } from './components/validation/validation.component';
import { SignupComponent } from './components/signup/signup.component';
import { WelcomeComponent } from './components/welcome/welcome.component';





export const routes: Routes = [
  { path: '', component: WelcomeComponent }, 
  {path: "navbar", component: NavBarComponent },
  { path: "acceuil", component: AcceuilComponent },
  {path: "FilesSubmission", component: FilesSubmissionComponent},
  {path: "Validation",component:ValidationComponent},
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },

];