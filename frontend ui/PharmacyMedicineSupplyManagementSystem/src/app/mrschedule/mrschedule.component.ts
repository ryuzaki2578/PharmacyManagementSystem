import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MrScheduleService } from '../mrschedule.service';

@Component({
  selector: 'app-mrschedule',
  templateUrl: './mrschedule.component.html',
  styleUrls: ['./mrschedule.component.css']
})
export class MRScheduleComponent implements OnInit {

  constructor(private mrScheduler:MrScheduleService,private httpClient:HttpClient) {

   }
   date:Date;

   getMr(){
     const newDate=new DatePipe('en-US').transform(this.date,'dd-MM-yyyy');
     console.log(newDate);
    this.mrScheduler.getMrSchedule(newDate).subscribe(
      (response: any) =>{console.log(response);},
     );

   }

  ngOnInit(): void {
  }

}
