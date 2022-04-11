import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticateGuard } from './authenticate.guard';
import { DealerDashboardComponent } from './dealer/dashboard/dashboard.component';
import { DealerHomeComponent } from './dealer/home/home.component';
import { OrderComponent } from './dealer/order/order.component';
import { PaymentMsgComponent } from './dealer/payment-msg/payment-msg.component';
import { DealerProfileComponent } from './dealer/profile/profile.component';
import { FarmerDashboardComponent } from './farmer/dashboard/dashboard.component';
import { FarmerhomeComponent } from './farmer/farmerhome/farmerhome.component';
import { FarmerprofileComponent } from './farmer/farmerprofile/farmerprofile.component';
import { HomeComponent } from './home/home.component';
import { LoginlandingComponent } from './loginlanding/loginlanding.component';

const routes: Routes = [
  {
    path:"",
    component: HomeComponent
  },
  {
    path:"login",
    component: LoginlandingComponent,    
  },
  {
    path:"dealer",
    canActivate:[AuthenticateGuard],
    children:[
      {path:"dashboard",component: DealerHomeComponent},
      {path:"profile",component:DealerProfileComponent},
      {path:"order",component:OrderComponent},
      {path:"paymentstatus",component:PaymentMsgComponent}
    ],
    component: DealerDashboardComponent,    
  },
  {
    path:"farmer",
    canActivate:[AuthenticateGuard],
    children:[
      {path:"dashboard",component:FarmerhomeComponent},
      {path:"profile",component:FarmerprofileComponent}
      
  ],
    component: FarmerDashboardComponent,    
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
