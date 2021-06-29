import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/_service/authentication.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  authenticated: boolean;

  constructor(private authService: AuthenticationService,private router:Router) { }

  ngOnInit() {
    this.authenticated = this.authService.loggedIn
  }
  
  logout() {
    this.authService.logout();
  }
  refresh(): void {
    this.router.navigate([HeaderComponent]);
}


}
