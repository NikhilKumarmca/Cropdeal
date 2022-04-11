import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DealerHomeComponent } from './home/home.component';

const routes: Routes = [
  // {path:"dealer/dashboard",
  //   children:[
  //     {path:"profile",component:DealerHomeComponent}
  //   ],
  // component:DashboardComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DealerRoutingModule { }
