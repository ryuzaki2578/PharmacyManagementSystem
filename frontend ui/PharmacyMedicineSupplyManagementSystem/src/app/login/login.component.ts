import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_service/authentication.service';  

@Component({
  selector: 'app-admin-panel',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
  
    userId:string="";
    password:string="";
  
title = 'auth-guard-demo';  
  constructor(private router: Router,private _auth: AuthenticationService, private _router: Router) { 
    if (this._auth.loggedIn) {  
      this._router.navigate(['check-stocks']);  
    }  
  }

  login(): void {  
    if (this.userId != '' && this.password != '') {  
      if (this._auth.login(this.userId, this.password)) {  
        this._router.navigate(["check-stocks"]);  
      }  
      else  
        alert("Wrong username or password");  
    }  
 
}

}
