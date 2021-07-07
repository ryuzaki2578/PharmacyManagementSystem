import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MedicineDemand } from './medicine-demand';

@Injectable({
  providedIn: 'root'
})
export class PharmacySupplyService {

  constructor(private httpClient:HttpClient) { }
  getMedicineSupplyCount(medicinedemand:MedicineDemand[]){
    const token=localStorage.getItem('accessToken');
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}`});
    return this.httpClient.post("http://15.164.180.169:8083/api/pharmacy-medicine-supply/pharmacy-supply",medicinedemand,{headers});
  }
  getPharmcySupply(){
    const token=localStorage.getItem('accessToken');
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}`});
    //console.log(token);
    return this.httpClient.get("http://15.164.180.169:8083/api/pharmacy-medicine-supply/getMedicineDemand",{headers});
  }
}