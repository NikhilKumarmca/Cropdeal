import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FarmerServiceService } from '../farmer-service.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  farmerdata = JSON.parse(localStorage.getItem("Farmer"))
  
  constructor(private farmerservice:FarmerServiceService,private _snackBar: MatSnackBar,public dialogRef: MatDialogRef<AddproductComponent>,@Inject(MAT_DIALOG_DATA) public data) { }
  addbtn:boolean=this.data.addbtn
  updatebtn:boolean=this.data.updatebtn
  header=this.data.header;
  product={
    productName:this.data.product.productName,
    productType:this.data.product.productType,
    productPrice:this.data.product.productPrice,
    location:this.data.product.location,
    farmerEmail:""
  };
  ngOnInit(): void {
  }

  oncancel(){
    this.dialogRef.close()
  }

  updatepro(value){
    this.product = value;
    console.log(this.data.product.productId);
    
    this.farmerservice.updateproduct(this.data.product.productId,this.product).subscribe((updateres)=>{
      console.log(updateres);
      this._snackBar.open('Product Updated','', {duration: 3000});
      
    })
  }

  addPro(value){
    this.product = value;
    this.product.farmerEmail = this.farmerdata.farmerEmail;
    if(this.product!=null)
    {
      this.farmerservice.addproductbyemail(this.product).subscribe((productres)=>{
        console.log("productres ",productres);
        this._snackBar.open('Product Added','', {duration: 3000});
        this.dialogRef.close()
        
      })
    }
   
    
  }
}
