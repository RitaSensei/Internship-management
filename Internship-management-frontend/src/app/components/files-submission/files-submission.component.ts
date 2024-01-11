import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { UploadService } from '../../services/UploadService/upload.service';

@Component({
  selector: 'app-files-submission',
  standalone: true,
  imports: [RouterModule,NavBarComponent,FooterComponent],
  templateUrl: './files-submission.component.html',
  styleUrl: './files-submission.component.css'
})
export class FilesSubmissionComponent {
  /*file: File = new File([], '');
 
 constructor(
   private uploadService: UploadService
 ){
 
 }
 
 onFilechange(event: any) {
   console.log(event.target.files[0])
   this.file = event.target.files[0]
 }
 
 upload() {
   if (this.file) {
     this.uploadService.uploadfile(this.file).subscribe(resp => {
       alert("Uploaded")
     })
   } else {
     alert("Please select a file first")
   }
 }*/
}


