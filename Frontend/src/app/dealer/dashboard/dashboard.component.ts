import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DealerserviceService } from '../dealerservice.service';

@Component({
  selector: 'dealer-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DealerDashboardComponent implements OnInit {
  email
  constructor(private router:Router,public dealerData:DealerserviceService) { 
    this.dealerData.dealerbyemail(this.dealer.dealerEmail).subscribe((data)=>{
      this.email =  data
    })
    
   
  }
  dealer = JSON.parse(localStorage.getItem("Dealer"))
  ngOnInit(): void {
    
  }

  

  logout()
  {
    sessionStorage.clear();
    localStorage.clear();
  }

}
