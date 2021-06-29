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
  constructor(private httpCLient:HttpClient,private router:Router){}
  login(userId: string, password: string) {  
    this.httpCLient.post<UserToken>(this.apiUrl,{userId,password}).subscribe((response:UserToken)=>{this.jwtResponse=response;},
    (error:HttpErrorResponse)=>{alert("Invalid Credentials");this.router.navigate(['login'])});
    localStorage.setItem('currentUser',this.jwtResponse.userId);
    localStorage.setItem('accessToken',this.jwtResponse.authToken);
    return this.loggedIn;
    // if (userId == "admin" && password == "admin") {  
    //   localStorage.setItem('currentUser', "loggedin");  
    //   return true;
    // }
    // return false;  
  }  
  logout() {  
    localStorage.removeItem('currentUser');  
  }  
  public get loggedIn(): boolean {  
    return (localStorage.getItem('currentUser') !== null);  
  }  

} 
