import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MedicineDemand } from '../medicine-demand';
import { PharmacySupplyService } from '../pharmacy-supply.service';

@Component({
  selector: 'app-medicine-demand',
  templateUrl: './medicine-demand.component.html',
  styleUrls: ['./medicine-demand.component.css']
})
export class MedicineDemandComponent implements OnInit {

  constructor(private pharmacyService:PharmacySupplyService) { }
  medicineDemand:MedicineDemand[]=[{"medicineName":"Crocin","demandCount":"1"}];
  ngOnInit(): void {
    //this.pharmacyService.getPharmcySupply().subscribe((response)=>(console.log(response)));
    this.pharmacyService.getMedicineSupplyCount(this.medicineDemand).subscribe((response)=>(console.log(response)),(error:HttpErrorResponse)=>(console.log(error)));
  }

}
