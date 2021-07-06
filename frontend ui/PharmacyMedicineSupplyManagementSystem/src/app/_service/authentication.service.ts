import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';  
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { UserToken } from '../user-token';
@Injectable({  
  providedIn: 'root'  
})  
export class AuthenticationService {  
  private apiUrl=environment.apiBaseUrlLogin;
  private jwtResponse:UserToken;
  constructor(private httpClient:HttpClient,private router:Router){}
  login(userId: string, password: string) {  
    this.httpClient.post<UserToken>(this.apiUrl,{userId,password}).subscribe((response:UserToken)=>{this.jwtResponse=response;},
    (error:HttpErrorResponse)=>
    {alert("Invalid Credentials");
    this.router.navigate(['login'])}
    );
    localStorage.setItem('currentUser',this.jwtResponse.userId);
    localStorage.setItem('accessToken',this.jwtResponse.authToken);
    return this.loggedIn;
  }  
  logout() {  
    localStorage.removeItem('currentUser');  
  }  
  public get loggedIn(): boolean {  
    return (localStorage.getItem('currentUser') !== null);  
  }  

} 
