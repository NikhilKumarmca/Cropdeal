import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FarmerDashboardComponent } from './dashboard/dashboard.component';
import { FarmerhomeComponent } from './farmerhome/farmerhome.component';
import { FarmerprofileComponent } from './farmerprofile/farmerprofile.component';
import { FarmerRoutingModule } from './farmer-routing.module';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { AddproductComponent } from './addproduct/addproduct.component';
import { MatInputModule } from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import { FarmerheaderComponent } from './farmerheader/farmerheader.component';


@NgModule({
  declarations: [
    FarmerDashboardComponent,
    FarmerhomeComponent,
    FarmerprofileComponent,
    AddproductComponent,
    FarmerheaderComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    FarmerRoutingModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatTableModule

  ],

  exports:[
    FarmerDashboardComponent,
    FarmerhomeComponent,
    FarmerprofileComponent
  ]
})
export class FarmerModule { }
