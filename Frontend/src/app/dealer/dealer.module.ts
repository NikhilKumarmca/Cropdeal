import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DealerRoutingModule } from './dealer-routing.module';
import { DealerDashboardComponent } from './dashboard/dashboard.component';
import { DealerProfileComponent } from './profile/profile.component';
import { DealerHomeComponent } from './home/home.component';
import { LoginService } from '../login.service';
import { FormsModule, NgForm } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { QantitydialogComponent } from './qantitydialog/qantitydialog.component';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { OrderComponent } from './order/order.component';
import {MatDialogModule} from '@angular/material/dialog';
import { PaymentMsgComponent } from './payment-msg/payment-msg.component';
import {MatIconModule} from '@angular/material/icon';
import { UpdateMsgComponent } from './update-msg/update-msg.component';
import { ReportComponent } from './report/report.component';
import { DealerheaderComponent } from './dealerheader/dealerheader.component';
import { FarmerviewComponent } from './farmerview/farmerview.component';


@NgModule({
  declarations: [
    DealerDashboardComponent,
    DealerProfileComponent,
    DealerHomeComponent,
    QantitydialogComponent,
    OrderComponent,
    PaymentMsgComponent,
    UpdateMsgComponent,
    ReportComponent,
    DealerheaderComponent,
    FarmerviewComponent,
  ],
  imports: [
    CommonModule,
    DealerRoutingModule,
    BrowserModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatIconModule
    

  ],
  exports:[
    DealerDashboardComponent,
    DealerProfileComponent,
    DealerHomeComponent,
  ],
  providers: [LoginService]
})
export class DealerModule { }
