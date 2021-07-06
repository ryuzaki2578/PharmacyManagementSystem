import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
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

  constructor(private stocksService:StocksService,private router:Router) { }
  profileForm = new FormGroup({
    name: new FormControl(''),
    quantity:new FormControl(''),
  });
  
  ngOnInit(): void {
    this.getStocks();
  }
  onSubmit() {
    //console.log(this.profileForm.value);
    this.updatestock(this.profileForm.value);
  }
  public updatestock(medicine:UpdateStocks)
  {
   this.stocksService.updateStocks(medicine.name,  medicine.quantity).subscribe((response)=>{ alert("Stocks has been updated");this.router.navigateByUrl('check-stocks');},
   (error:HttpErrorResponse)=>{alert(error.error.message);this.router.navigateByUrl('check-stocks')}
   );
  

  }
  public getStocks():void
  {
    this.stocksService.getStocks().subscribe(
      (response:Stocks[]) =>{this.handleSuccessfulResponse(response)},(error:HttpErrorResponse)=>(alert(error.message)));
  }
  handleSuccessfulResponse(response: Stocks[])
  {
      this.stocks=response;
  }
}
