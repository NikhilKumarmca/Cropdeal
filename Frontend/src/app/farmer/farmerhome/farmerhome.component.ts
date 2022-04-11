import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddproductComponent } from '../addproduct/addproduct.component';
import { FarmerServiceService } from '../farmer-service.service';

@Component({
  selector: 'app-farmerhome',
  templateUrl: './farmerhome.component.html',
  styleUrls: ['./farmerhome.component.css']
})
export class FarmerhomeComponent implements OnInit {
  farmer = JSON.parse(localStorage.getItem("Farmer"));
  farmerproducts;
  
  constructor(private farmerservice:FarmerServiceService,public dialog: MatDialog) { 
    this.farmerservice.getproductbyid(this.farmer.farmerEmail).subscribe((productres)=>{
      console.log(productres);

      var farmerpro = JSON.stringify(productres);
      this.farmerproducts = JSON.parse(farmerpro)
    });
    
    
  }

  ngOnChanges(){
    this.farmerservice.getproductbyid(this.farmer.farmerEmail).subscribe((productres)=>{
      console.log(productres);

      var farmerpro = JSON.stringify(productres);
      this.farmerproducts = JSON.parse(farmerpro)
    });
  }

  add()
  {
    var pro=[]
    this.dialog.open(AddproductComponent, {
      width: '400px',data:{addbtn:true,updatebtn:false,header:"Add Your Product",product:pro}});

      
  }

  edit(i)
  {
    
    this.dialog.open(AddproductComponent,{width: '400px',data:{addbtn:false,updatebtn:true,header:"Edit Your Product",product:this.farmerproducts[i]}})
    
  }

  delete(i){
    
    this.farmerservice.deleteproduct(this.farmerproducts[i].productId).subscribe((deleteres)=>{
      console.log(deleteres);
      
    })
  }

  ngOnInit(): void {
    
    
      
    
  }

}
