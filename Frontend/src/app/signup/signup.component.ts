import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  registerArray:any={}
  hide:boolean=true;
  chide:boolean=true;
  client:any;
  constructor(private Reg: LoginService,private _snackBar: MatSnackBar,public dialog: MatDialog) {

    
   }


   getsignupclient(e)
  {
    this.client=e;
    console.log(this.client);
  }
  ngOnInit(): void {
  }

  farmeruser={
    farmerEmail:"",
    confirmpassword:"",
    farmerPassword:""
  };
  dealeruser={
    dealerEmail:"",
    confirmpassword:"",
    dealerPassword:""
  };
  user={
    email:"",
    password:""
  };
  registation(data)
  {
    
      if(this.client=="farmer")
      {        
        this.farmeruser=data;
        if(this.farmeruser.confirmpassword == this.farmeruser.farmerPassword)
        {
          this.Reg.FindFarmerbyemail(this.farmeruser.farmerEmail).subscribe((getres)=>{
            if(getres)
            {
              console.log("you are already registered");
              this.dialog.open(AlreadyReg);
              
            }
            else{
              this.user.email=this.farmeruser.farmerEmail;
              this.user.password=this.farmeruser.farmerPassword;
              console.log(this.user.email);
              this.Reg.AuthRegister(this.user).subscribe((authres)=>{
                if(authres)
                {
                  console.log(authres);     
                  this.Reg.FarmerRegister(this.farmeruser).subscribe((result)=>{
                    console.log(result);
                    this._snackBar.open("Your are successfully registered","Ok");
                  });             
                }
              });
            
            }

          });


         
          
        }
        else
        {
          // this.dialog.open(AlreadyReg);
          this._snackBar.open("Password not matched","Ok");
          
        }
        
        
  
      }
      else
      {
        this.dealeruser=data;
        if(this.dealeruser.confirmpassword == this.dealeruser.dealerPassword)
        {
          
          this.Reg.FindDealerbyemail(this.dealeruser.dealerEmail).subscribe((getres)=>{
            if(getres)
            {
              console.log("you are already registered");
              this.dialog.open(AlreadyReg);
              
            }
            else{
              this.user.email=this.dealeruser.dealerEmail;
              this.user.password=this.dealeruser.dealerPassword;
              console.log(this.user.email);
              this.Reg.AuthRegister(this.user).subscribe((authres)=>{
                if(authres)
                {
                  console.log(authres);   
                  this.Reg.DealerRegister(this.dealeruser).subscribe((result)=>{
                    this._snackBar.open("Your are successfully registered","Ok");
                    });               
                }
              });
              
              
            }
          });

          // if(success=="success")
          // {
          //   this.dialog.open(AlreadyReg);
          // }
          // else{
          //   this.Reg.DealerRegister(this.dealeruser).subscribe((result)=>{
          //     // console.log(result);
          //     this._snackBar.open("Your are successfully registered","Ok");
          //     });
          // }

           console.log(this.dealeruser.dealerEmail);
           
          
          // this.Reg.DealerRegister(this.dealeruser).subscribe((result)=>{
          // console.log(result);
          // this._snackBar.open("Your are successfully registered","Ok");
          // });
            
            
        }
        else
        {
          this._snackBar.open("Password not matched","Ok");
        }
        
      }
      
  
    
    
      
    
  }
}

@Component({
  selector: 'alreadyreg',
  templateUrl: './alreadyreg.html',
})
export class AlreadyReg {}

@Component({
  selector: 'regsuccess',
  templateUrl: './regsuccess.html',
})
export class Regsuccess {}