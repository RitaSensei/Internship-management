import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(
    private httpClient: HttpClient,
  ) { }
  
  public uploadfile(file: File) {
    let formParams = new FormData();
    formParams.append('file', file)
    return this.httpClient.post('http://localhost:8080/api/upload', formParams)
  }
 }