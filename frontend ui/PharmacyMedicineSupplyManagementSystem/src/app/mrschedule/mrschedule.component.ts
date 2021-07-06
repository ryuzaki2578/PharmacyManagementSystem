import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef,ViewChild } from '@angular/core';
import { MrScheduleService } from '../mrschedule.service';
import { Mrschedule } from '../mrschedule.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-mrschedule',
  templateUrl: './mrschedule.component.html',
  styleUrls: ['./mrschedule.component.css']
})
export class MRScheduleComponent implements OnInit {
  schedule:Mrschedule[];
  constructor(private modalService: NgbModal,private mrScheduler:MrScheduleService,private httpClient:HttpClient) {

   }
   date:Date;
   data:any;
   getMr(){
     
     const newDate=new DatePipe('en-US').transform(this.date,'dd-MM-yyyy');
    this.mrScheduler.getMrSchedule(newDate).subscribe(
      (response: any) =>{this.data=response;
        this.handleSuccessfulResponse(this.data)},(error:any)=>(alert(error))
     );
   }
   handleSuccessfulResponse(response: Mrschedule[])
{
    this.schedule=response;
}

@ViewChild('editModal') editModal : TemplateRef<any>;

openModal(){
  this.modalService.open(this.editModal);
}

  ngOnInit(): void {
  }

}
