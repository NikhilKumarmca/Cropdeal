import { Component, NgZone, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DealerserviceService } from '../dealerservice.service';
import { FarmerviewComponent } from '../farmerview/farmerview.component';
import { QantitydialogComponent } from '../qantitydialog/qantitydialog.component';

// export interface DialogData {
//   quantity: number;
//   price: number;
// }
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class DealerHomeComponent implements OnInit {
  products:any;
  paystatus;
  order:any={
    dealerEmail:"",
    productName:"",
    productPrice:"",
    productQnt:""    
  };
  transdata={
    dealerId:"",
    amount:""
  };
  constructor(public productData:DealerserviceService,public dialog: MatDialog,private router:Router,public zone:NgZone) { 
    productData.productList().subscribe((data)=> {
      this.products=data;
      console.log(this.products);
    });
  }
  dealer = JSON.parse(localStorage.getItem('Dealer'));



  openDialog(i): void {
    
        
    const dialogRef = this.dialog.open(QantitydialogComponent, {
      width: '250px',
      data: this.products[i].productPrice
      
    }
    
    );

  
  
    dialogRef.afterClosed().subscribe(result => {
      
      if(result)
      {
        this.order.productQnt = result;
        var amount:number = (this.products[i].productPrice)*(this.order.productQnt);
          this.order.totalAmt = amount;
          this.order.productName = this.products[i].productName
          this.order.productPrice = this.products[i].productPrice
          this.order.dealerEmail = this.dealer.dealerEmail;
          this.productData.createTran(this.order).subscribe((trxres)=>{
            var tra = JSON.stringify(trxres);
            this.paystatus = JSON.parse(tra);
                   
            if(this.paystatus.status=="created")
            {
              
              let options = {
                key : "rzp_test_TL2qlHMYIy8nUO",
                amount : this.paystatus.amount,
                currency:"INR",
                name:"Payment for CropDeal",
                description:"Pay to CropFarmer",
                image:"https://www.graphicsprings.com/filestorage/stencils/9b8b99137c12847ef780dd402b8a4070.png?width=500&height=500",
                order_id:this.paystatus.id,
                handler:this.paymenthandler.bind(this),
               
                prefill: {
                  name: this.dealer.dealerName,
                  email: this.dealer.dealerEmail,
                  contact: this.dealer.dealerPhone
                },
                notes: {
                  "address": "CropDeal private LTD"
                },
                theme: {
                  "color": "#3399cc"
                }
              };
              var rzp = new this.productData.nativeWindow.Razorpay(options);
              // rzp.on('payment.failed', function (res){
              //   console.log(res.error.code);
              //   console.log(res.error.description);
              //   console.log(res.error.source);
              //   console.log(res.error.step);
              //   console.log(res.error.reason);
              //   console.log(res.error.metadata.order_id);
              //   console.log(res.error.metadata.payment_id);
              //   this.paystatus="failed";
              //   alert("Oops!!! payment failed...")
              // });
              rzp.open();
              
              
            } 
           
            
           
          });
      }
      else
      {
        console.log("result has nothing");
      }
    });
    

  }
  paymenthandler(res){
    this.zone.run(() =>{
      
      var paidorder = JSON.stringify(this.order);
      localStorage.setItem("order",paidorder);
      return this.router.navigate(['dealer/paymentstatus',{order:res.razorpay_order_id,payid:res.razorpay_payment_id,status:"paid"}]);
    })
  }
  
view(i){

  
this.productData.getfarmerdata(this.products[i].farmerEmail).subscribe((farmerres)=>{
  this.dialog.open(FarmerviewComponent, {
    data: {
      farmer:farmerres ,
    },
  });
})

  }

  ngOnInit(): void {
  }
  

  

  

}




