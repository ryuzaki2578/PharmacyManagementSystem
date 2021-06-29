import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class Mrschedule{
  constructor(
    public id:number,
    public repName:string,
    public doctorName:string,
    public meetingSlot:string,
    public meetingDate:string,
    public doctorContactNumber:number,
    public medicines:String[],
    public treatingAilment:String
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class MrScheduleService {

  constructor(private httpClient:HttpClient) { }
  getMR()
  {
    let username=''
    let password=''
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    
       return this.httpClient.get<Mrschedule[]>('http://localhost:8082/medicalRepresentatives',{headers});
  }
  getMrSchedule(date:string){
      return this.httpClient.get<any>('http://localhost:8082/medicalRepresentatives');
  }
}

