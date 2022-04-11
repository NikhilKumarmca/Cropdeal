import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { FarmerServiceService } from '../farmer-service.service';

@Component({
  selector: 'farmer-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class FarmerDashboardComponent implements OnInit {
  email;
  farmer = JSON.parse(localStorage.getItem("Farmer"));
  constructor(private router:Router,public farmerData:FarmerServiceService) { 
  this.farmerData.farmerbyemail(this.farmer.farmerEmail).subscribe((data)=>{
    this.email = data
  })
   
  }

  ngOnInit(): void {
   
  }

  logout()
  {
    sessionStorage.clear();
    localStorage.clear();
  }
  

}
