import { Component } from '@angular/core';
import {  RouterModule, RouterOutlet } from '@angular/router';
import { routes } from '../../app.routes';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [RouterOutlet,RouterModule],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent {

}
