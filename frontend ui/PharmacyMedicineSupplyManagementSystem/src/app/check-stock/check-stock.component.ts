import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../_service/authentication.service';
import { Router } from '@angular/router';  
import { HttpClientService } from '../_service/http-client.service';
import { StocksService,Stocks } from '../stocks.service';
@Component({
  selector: 'app-check-stock',
  templateUrl: './check-stock.component.html',
  styleUrls: ['./check-stock.component.css']
})
export class CheckStockComponent implements OnInit {
  stocks:Stocks[];

  constructor(private router: Router,private authenticationService: AuthenticationService,private stocksService:StocksService) { }

ngOnInit(): void {
    this.stocksService.getStocks().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }
  handleSuccessfulResponse(response: Stocks[])
{
    this.stocks=response;
}

}
