import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';


@Injectable({
  providedIn: 'root'
})
export class BasicAuthHttpInterceptorService implements HttpInterceptor {

  
  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    var token=localStorage.getItem('accessToken');
    if (localStorage.getItem('userId') && token) {
      req = req.clone({
        setHeaders: {
          Authorization: "bearer  "+ token
        }
      })
    }

    return next.handle(req);

  }
}
