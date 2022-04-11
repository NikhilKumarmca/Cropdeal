import { Component, OnInit } from '@angular/core';
import { DealerserviceService } from '../dealerservice.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  constructor(private trans:DealerserviceService) { }

  ngOnInit(): void {
    this.trans.getalltran().subscribe((transres)=>{
      console.log(transres);
      
    })
  }

}
