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
    const token=localStorage.getItem('accessToken');
    //console.log(token);
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}`});
       return this.httpClient.get<Mrschedule[]>('http://15.164.180.169:8082/api/medical-representative-schedule-service/RepSchedule',{headers});
  }
  getMrSchedule(date:any){
    
    const token=localStorage.getItem('accessToken');
    const headers = new HttpHeaders({ Authorization: `Bearer ${token}`});
      return this.httpClient.get<any>('http://15.164.180.169:8082/api/medical-representative-schedule-service/RepSchedule/'+date,{headers});
  }
  
}

