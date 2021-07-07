import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MedicineDemand } from '../medicine-demand';
import { PharmacySupplyService } from '../pharmacy-supply.service';
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

  constructor(private fb:FormBuilder,private stocksService:StocksService,private router:Router,private pharmacyService:PharmacySupplyService) 
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
      medicineName: '',  
      demandCount: '',  
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
    //console.log(this.productForm.get('quantities')?.value);
    this.getPharmacySupply(this.productForm.get('quantities')?.value);
  }
  getPharmacySupply(medicinedemand:MedicineDemand[]){
    this.pharmacyService.getMedicineSupplyCount(medicinedemand).subscribe((response)=>{alert("SuccessfullyAddedSupply");this.router.navigateByUrl('medicine-demand')},
    (error:HttpErrorResponse)=>{alert(error.error.message);}
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
