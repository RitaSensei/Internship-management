import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { NavBarComponent } from '../nav-bar/nav-bar.component';
import { FileUploadService } from '../../services/UploadService/upload.service';
import { Observable } from 'rxjs';
import { HttpEventType, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-files-submission',
  standalone: true,
  imports: [RouterModule,NavBarComponent,FooterComponent],
  templateUrl: './files-submission.component.html',
  styleUrl: './files-submission.component.css'
})
export class FilesSubmissionComponent implements OnInit {
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';

  fileInfos?: Observable<any>;

  constructor(private uploadService: FileUploadService) { }
  ngOnInit(): void {
    this.fileInfos = this.uploadService.getFiles();
  }
  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }

  upload(): void {
    console.log("hello");
    this.progress = 0;
  
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
  
      if (file) {
        this.currentFile = file;
  
        this.uploadService.upload(this.currentFile).subscribe({
          next: (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              this.fileInfos = this.uploadService.getFiles();
  
              // Log success message to console
              console.log('File uploaded successfully!');
            }
          },
          error: (err: any) => {
            console.log(err);
            this.progress = 0;
  
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'File upload failed, please try again.';
            }
  
            this.currentFile = undefined;
          }
        });
      }
  
      this.selectedFiles = undefined;
    }
  }}
  

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

