import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
val
islogin:boolean=true
  constructor(private _activerout:ActivatedRoute) {
    
    console.log(JSON.parse(sessionStorage.getItem("token")));
  
   }
 
  
  ngOnInit(): void {
    if(JSON.parse(sessionStorage.getItem("token")))
    {
      this.islogin=false;
    }
    this.islogin=true
  }
   
    

  logout(){
     sessionStorage.clear();
     localStorage.clear();
  }

  

}
