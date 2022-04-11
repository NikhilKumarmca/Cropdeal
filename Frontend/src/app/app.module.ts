import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatDialogClose, MatDialogModule,} from '@angular/material/dialog';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FarmerModule } from './farmer/farmer.module';
import { HeaderComponent } from './header/header.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SignupComponent } from './signup/signup.component';
import { FormsModule } from '@angular/forms';
import { LoginService } from './login.service';
import { HttpClientModule } from '@angular/common/http';
import { DealerModule } from './dealer/dealer.module';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { LoginlandingComponent } from './loginlanding/loginlanding.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { DialogMsgComponent } from './dialog-msg/dialog-msg.component';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    FooterComponent,
    DialogMsgComponent,
    LoginlandingComponent
  ],
  imports: [
    AppRoutingModule,
    FarmerModule,
    DealerModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSnackBarModule,
    NgbModule,
    BrowserAnimationsModule,
    FormsModule,
    BrowserModule,
    MatDialogModule,
    MatButtonModule
  ],
  exports:[
    LoginComponent,LoginlandingComponent
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
