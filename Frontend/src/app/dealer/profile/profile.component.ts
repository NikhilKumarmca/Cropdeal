import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DealerserviceService } from '../dealerservice.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class DealerProfileComponent implements OnInit {
  client;
  hide;
  isReadonly:boolean=true
  chide;
  registerArray:any={}
  updatedDealer={};
  constructor(private Dealerdata:DealerserviceService,private _snackBar: MatSnackBar) { 
    
    
  }
  

  ngOnInit(): void {
    var dealer=JSON.parse(localStorage.getItem("Dealer"));
     var dealerEmail = dealer.dealerEmail;

    this.registerArray = this.Dealerdata.dealerbyemail(dealerEmail).subscribe((getdealer)=>{
      this.registerArray=getdealer;
      
    });

    
  }

  edit()
  {
    return this.isReadonly=!this.isReadonly
  }

  onUpdate()
  {
    var updatedDealer = this.registerArray
    var email = this.registerArray.dealerEmail;
    
    this.Dealerdata.dealerupdata(email,updatedDealer).subscribe((updatedres)=>{
      if(updatedres)
      {
        this.isReadonly=!this.isReadonly;
        this._snackBar.open('Profile Updated','', {duration: 3000});
      }
    })

  }

}
