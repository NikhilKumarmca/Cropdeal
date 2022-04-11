import { Component, OnInit } from '@angular/core';
import { DealerserviceService } from '../dealerservice.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  dealer = JSON.parse(localStorage.getItem("Dealer"));
  orders;
  ordertrans={
    
  };
  butn:boolean=true;
  constructor(private order:DealerserviceService) { 
    
  }

  ngOnInit(): void {
    
    console.log("dealer id",this.dealer.dealerId);
    this.order.Dealerorderlist(this.dealer.dealerEmail).subscribe((orderlist)=>{
      this.orders = orderlist;
      let objlenth = Object.keys(orderlist).length;
      for(let i=0;i<objlenth;i++)
      {
        if(this.orders[i].status=="success")
        {
          console.log("your order completed");
          
          
          
        }
      //   else
      //   {
      //     console.log("you need to pay");

          
      //   }
      }
      
    })

    
  }

  // onPay(i)
  // {
  //     if(this.orders[i].status=="success")
  //     {
  //         document.getElementsByClassName('.payment'[i]) ;
          
  //     }
  //     else
  //     {
        // var amount:number = (this.orders[i].productPrice)*(this.orders[i].productQnt);
        // this.ordertrans = amount;
        // console.log(amount);
        // this.order.createTran(amount).subscribe((trxres)=>{
        //   var tra = JSON.stringify(trxres);
        //   var tra1 = JSON.parse(tra);

        //   if(tra1.status=="created")
        //   {
        //     let options = {
        //       key : "rzp_test_TL2qlHMYIy8nUO",
        //       amount : tra1.amount,
        //       currency:"INR",
        //       name:"Payment for CropDeal",
        //       description:"Pay to CropFarmer",
        //       image:"https://www.graphicsprings.com/filestorage/stencils/9b8b99137c12847ef780dd402b8a4070.png?width=500&height=500",
        //       order_id:tra1.id,
        //       handler:function(res){
        //         console.log(res.razorpay_payment_id);
        //         console.log(res.razorpay_order_id);
        //         console.log(res.razorpay_signature);
        //         console.log("payment successfull.");
                
                
        //       },
        //       prefill: {
        //         name: "",
        //         email: "",
        //         contact: ""
        //       },
        //       notes: {
        //         "address": "CropDeal private LTD"
        //       },
        //       theme: {
        //         "color": "#3399cc"
        //       }

        //     };

        //     var rzp = new this.order.nativeWindow.Razorpay(options);

        //     rzp.on('payment.failed', function (response){
        //       console.log(response.error.code);
        //       console.log(response.error.description);
        //       console.log(response.error.source);
        //       console.log(response.error.step);
        //       console.log(response.error.reason);
        //       console.log(response.error.metadata.order_id);
        //       console.log(response.error.metadata.payment_id);
        //       alert("Oops!!! payment failed...")
        //     });
        //     rzp.open();

        //   }
          
          
        // })

        
      // }
  // }

}


