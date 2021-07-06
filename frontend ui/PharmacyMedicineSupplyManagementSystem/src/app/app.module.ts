import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';

import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home/home.component'; 
import { StocksComponent } from './stocks/stocks.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { CheckStockComponent } from './check-stock/check-stock.component';
import { BasicAuthHttpInterceptorService } from './_service/basic-auth-http-interceptor.service';
import { CommonModule } from '@angular/common';
import { MRScheduleComponent } from './mrschedule/mrschedule.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    AppComponent,
    LoginComponent,
    PlaceOrderComponent,
    HomeComponent,
    StocksComponent,
    CheckStockComponent,
    AboutUsComponent,
    ContactUsComponent,
    MRScheduleComponent,
    PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
  ],
  providers: [
    {  
      provide:HTTP_INTERCEPTORS, useClass:BasicAuthHttpInterceptorService, multi:true 
    }
    ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
