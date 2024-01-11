import { Component } from '@angular/core';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { FooterComponent } from '../footer/footer.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-files-fin-stage',
  standalone: true,
  imports: [RouterModule,NavBarComponent,FooterComponent],
  templateUrl: './files-fin-stage.component.html',
  styleUrl: './files-fin-stage.component.css'
})
export class FilesFinStageComponent {

}
