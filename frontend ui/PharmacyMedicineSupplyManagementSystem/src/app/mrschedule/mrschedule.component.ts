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
   date:string;

   submit(){
     console.log('called');
    this.mrScheduler.getMrSchedule(this.date).subscribe(
      (response: any) =>{console.log(response);},
     );

   }

  ngOnInit(): void {
  }

}
