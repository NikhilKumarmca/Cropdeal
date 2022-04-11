import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DealerserviceService } from '../dealerservice.service';

@Component({
  selector: 'app-payment-msg',
  templateUrl: './payment-msg.component.html',
  styleUrls: ['./payment-msg.component.css']
})
export class PaymentMsgComponent implements OnInit {

  constructor(private _activerout:ActivatedRoute,private trans:DealerserviceService,private router:Router ) { }
  public order={
    orderId:"",
    paymentId:"",
    status:""
  };
  orderData={};
  ngOnInit(): void {
    this.order.orderId = this._activerout.snapshot.paramMap.get('order');
    this.order.paymentId = this._activerout.snapshot.paramMap.get('payid');
    this.order.status = this._activerout.snapshot.paramMap.get('status');
    console.log(this.order);
    if(this._activerout.snapshot.paramMap.get('status')=="paid")
    {
      console.log("you successfully pay");
      this.trans.updateTran(this.order).subscribe((trnsres)=>{
            console.log(trnsres);
            this.orderData = JSON.parse(localStorage.getItem("order"));
            this.trans.Dealerordercreate(this.orderData).subscribe((result)=>{
              console.log("order result ",result);
              
            }
            )
            
          })
      
    }
    else
    {
      console.log("transaction failed");
      
    }
  }

  onOrder(){
    this.router.navigate(['../dealer/order'])
  }

}
