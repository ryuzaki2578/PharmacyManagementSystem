import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MedicineDemand } from '../medicine-demand';
import { PharmacySupplyService } from '../pharmacy-supply.service';

@Component({
  selector: 'app-medicine-supply',
  templateUrl: './medicine-supply.component.html',
  styleUrls: ['./medicine-supply.component.css']
})
export class MedicineSupplyComponent implements OnInit {

  medicinedemand:MedicineDemand[];

  constructor(private pharmacyService:PharmacySupplyService) { }

  ngOnInit(): void {
  }

  getPharmacySupply(){
    this.pharmacyService.getMedicineSupplyCount(this.medicinedemand).subscribe((response)=>{alert("SuccessfullyAddedSupply")},
    (error:HttpErrorResponse)=>{alert(error.error.message);}
    );
  }

}
