import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class Stocks{
  constructor(
    public id:string,
    public name:string,
    public chemicalComposition:string,
    public targetAilment:string,
    public pharmacyName:string,
    public numberOfTabletsInStock:number
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class StocksService {
  constructor(private httpClient:HttpClient) { }
  getStocks()
  {
    const token=localStorage.getItem('token');
    console.log(token);
    const headers = new HttpHeaders({ Authorization: "Bearer " +token });
    
       return this.httpClient.get<Stocks[]>('http://localhost:8081/api/medicine-stock/medicine-stock-information',{headers});
  }
}

