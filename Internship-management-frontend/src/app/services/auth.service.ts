// auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth'; // Adjust this URL based on your backend

  constructor(private http: HttpClient) {}

  login(username: string, password: string, role: string): Observable<any> {
    const loginRequest = { username, password, role };
    return this.http.post(`${this.apiUrl}/sign-in`, loginRequest);
  }

  logout(): Observable<any> {
    return this.http.post(`${this.apiUrl}/sign-out`, {});
  }

  refreshToken(refreshToken: string, role: string): Observable<any> {
    const tokenRefreshRequest = { refreshToken, role };
    return this.http.post(`${this.apiUrl}/refreshtoken`, tokenRefreshRequest);
  }

  register(signUpRequest: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/sign-up`, signUpRequest);
  }

}
