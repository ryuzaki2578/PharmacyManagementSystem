import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { StocksService,Stocks,UpdateStocks} from '../stocks.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit{
  stocks: Stocks[];
  stock:UpdateStocks[];
  quantity:number;
  medicine:string;

  constructor(private stocksService:StocksService) { }
  profileForm = new FormGroup({
    mname: new FormControl(''),
    quantity:new FormControl(''),
  });
  ngOnInit(): void {
    this.getStocks();
  }
  onSubmit() {
    console.log(this.profileForm.value);
    this.updatestock(this.profileForm.value);
  }
  public updatestock(medicine:UpdateStocks)
  {
   
  }
  public getStocks():void
  {
    this.stocksService.getStocks().subscribe(
      response =>this.handleSuccessfulResponse(response));
  }
  handleSuccessfulResponse(response: Stocks[])
  {
      this.stocks=response;
  }
}
