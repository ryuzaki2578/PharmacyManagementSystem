import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { StocksService,Stocks,UpdateStocks} from '../stocks.service';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit{
  stocks: Stocks[];
  quantity:number;
  medicine:string;
  productForm: FormGroup;

  constructor(private fb:FormBuilder,private stocksService:StocksService,private router:Router) 
  {
    this.productForm = this.fb.group({   
      quantities: this.fb.array([]) ,  
    }); 
   }
   quantities() : FormArray {  
    return this.productForm.get("quantities") as FormArray  
  }  
  newQuantity(): FormGroup {  
    return this.fb.group({  
      name: '',  
      quantity: '',  
    })  
  }  
  addQuantity() {  
    this.quantities().push(this.newQuantity());  
  }  
     
  removeQuantity(i:number) {  
    this.quantities().removeAt(i);  
  }  
  
  ngOnInit(): void {
    this.getStocks();
  }
  onSubmit() {
    console.log(this.productForm.value);
    this.updatestock(this.productForm.value);
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
