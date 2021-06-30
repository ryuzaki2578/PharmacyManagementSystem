import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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
export class UpdateStocks{
  constructor(
    public quantity:number,
    public name:string,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class StocksService {
  constructor(private httpClient:HttpClient) { }
  getStocks()
  {
    const token=localStorage.getItem('accessToken');
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}`});
       return this.httpClient.get<Stocks[]>('http://localhost:8081/api/medicine-stock/medicine-stock-information',{headers});
  }
  updateStocks(medicine:string,count:number)
  {
    const token=localStorage.getItem('accessToken');
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}`});
    const url = `http://localhost:8081/api/medicine-stock/update-stock/${medicine}/${count}`;
    return this.httpClient.post(url,{headers})
  }
}

