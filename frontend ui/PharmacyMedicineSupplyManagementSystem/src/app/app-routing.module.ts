import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { CheckStockComponent } from './check-stock/check-stock.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login.component';
import { MRScheduleComponent } from './mrschedule/mrschedule.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { StocksComponent } from './stocks/stocks.component';
import { AuthGuard } from './_service/auth-guard.service';
const routes: Routes = [
  {path:'',component:HomeComponent},
{path:'stocks',component:StocksComponent,canActivate: [AuthGuard]},
  {path:'login',component:LoginComponent},
{path:'mr-schedule',component:MRScheduleComponent,canActivate: [AuthGuard]},
{path:'place-order',component:PlaceOrderComponent,canActivate: [AuthGuard]},
{path:'check-stocks',component:CheckStockComponent,canActivate: [AuthGuard]},
{path:'about-us',component:AboutUsComponent},
{path:'contact-us',component:ContactUsComponent},
{path:'**',component:PagenotfoundComponent}];
  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
