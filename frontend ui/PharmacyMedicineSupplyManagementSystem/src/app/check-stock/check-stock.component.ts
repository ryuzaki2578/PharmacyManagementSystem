import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_service/authentication.service';
import { Router } from '@angular/router';  

@Component({
  selector: 'app-check-stock',
  templateUrl: './check-stock.component.html',
  styleUrls: ['./check-stock.component.css']
})
export class CheckStockComponent implements OnInit {

  constructor(private router: Router,private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }
      
  logout() {  
    this.authenticationService.logout();  
    this.router.navigate(['']);  
  }  

}
