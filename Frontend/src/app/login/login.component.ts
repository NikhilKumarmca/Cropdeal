import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  name:any;
  hide:boolean=true;
  // profile:boolean;
  // home:boolean;
  // login:boolean;
  constructor(private login:LoginService,private router : Router,private _snackBar: MatSnackBar) { 
    
  }
  
  getclient(e)
  {
    this.name=e;
        
  }
  

  ngOnInit():void {
    sessionStorage.clear();
    localStorage.clear();
  }
  
  
  farmeruser={
   
  };
  dealeruser={
    dealerEmail:"",
    dealerPassword:""
  };
  user={
    email:"",
    password:""
  };
  sec=3;
  Login(data){
    
    // var dealeremail = data.dealerEmail;
    // var dealerpassword = data.dealerPassword;
    // console.log(dealeremail);
    // console.log(dealerpassword);
    
    if(this.name=="farmer")
    {

      this.farmeruser=data

      this.login.FarmerLoginUser(this.farmeruser).subscribe((result)=>{
        if(result==null)
        {
          this._snackBar.open("Bad cradential","ok");
          
        }
        else{
          
          localStorage.setItem("Farmer",JSON.stringify(result)); 

          var authdata = JSON.parse(localStorage.getItem("Farmer"));
          this.user.email=authdata.farmerEmail;
          this.user.password=authdata.farmerPassword;
          this.login.Auth(this.user).subscribe((farmerauthtoken)=>{
            let localtoken = farmerauthtoken;
            // console.log("by token",localtoken);
            console.log(this.user.password);
            
            if(farmerauthtoken)
            {
              sessionStorage.setItem("token",JSON.stringify(localtoken));
            
              if(sessionStorage.getItem("token"))
              {
                console.log("farmer token is in session");
                this.router.navigate(['./farmer/dashboard']);
                
              }
              else
              {
                this.router.navigate(["../login"]);
              }
            }
            else
            {
              this._snackBar.open("Session not created","ok"); 
            }
            
            
          })
         
        }
      });

    }
    else
    {
      this.dealeruser=data
      this.login.DealerLoginUser(this.dealeruser).subscribe((result)=>{

        if(result==null)
        {
          this._snackBar.open("Bad cradential","ok");
          
          
        }
        else{
          localStorage.setItem("Dealer",JSON.stringify(result)); 

          var authdata = JSON.parse(localStorage.getItem("Dealer"));
          this.user.email=authdata.dealerEmail;
          this.user.password=authdata.dealerPassword;
          
      

          this.login.Auth(this.user).subscribe((authtoken)=>{
            let localtoken = authtoken;
            // console.log("by token",localtoken);
            
            if(authtoken)
            {
              sessionStorage.setItem("token",JSON.stringify(localtoken));
            
              if(sessionStorage.getItem("token"))
              {
                console.log("token is in session");
                this.router.navigate(['./dealer/dashboard',{l:"success"}]);
                
              }
              else
              {
                this.router.navigate(["../login"]);
              }
            }
            else
            {
              this._snackBar.open("Session not created","ok"); 
            }
            
            
          })
          
        }
      });
    }

    
  }

  
}
