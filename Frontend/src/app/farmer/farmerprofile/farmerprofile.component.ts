import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FarmerServiceService } from '../farmer-service.service';

@Component({
  selector: 'app-farmerprofile',
  templateUrl: './farmerprofile.component.html',
  styleUrls: ['./farmerprofile.component.css']
})
export class FarmerprofileComponent implements OnInit {

  registerArray:any={}
  updatedDealer={};
  isReadonly:boolean=true
  constructor(private Farmerdata:FarmerServiceService,private _snackBar: MatSnackBar) { }

  edit()
  {
    return this.isReadonly=!this.isReadonly
  }

  onUpdate()
  {
    var updatedFarmer = this.registerArray
    var email = this.registerArray.farmerEmail;
    
    this.Farmerdata.farmerupdata(email,updatedFarmer).subscribe((updatedres)=>{
      if(updatedres)
      {
        this.isReadonly=true;
        this._snackBar.open('Profile Updated','', {duration: 3000});
      }
    })

  }

  ngOnInit(): void {

    var farmer=JSON.parse(localStorage.getItem("Farmer"));
     var farmerEmail = farmer.farmerEmail;

    this.registerArray = this.Farmerdata.farmerbyemail(farmerEmail).subscribe((getfarmer)=>{
      this.registerArray=getfarmer;
      
    });
  }

}
