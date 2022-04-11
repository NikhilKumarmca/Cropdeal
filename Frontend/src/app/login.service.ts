import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  
  public DealerbaseUrl="http://localhost:8002/dealer";
  public FarmerbaseUrl="http://localhost:8003/farmer";
  public AuthbaseUrl="http://localhost:8090/";
  constructor(public http:HttpClient) { }

  

  AuthRegister(data)
  {
    return this.http.post(this.AuthbaseUrl+"authreg",data);
  }

  Auth(data)
  {
    return this.http.post(this.AuthbaseUrl+"auth",data);
  }

  DealerRegister(data)
  {
    return this.http.post(this.DealerbaseUrl+"/list/add",data)
  }

  DealerLoginUser(data) {
    return this.http.post(this.DealerbaseUrl+"/login",data)
  }

  // DealerLoginUserbyemail(dealeremail,dealerpassword) {
  //   return this.http.get(this.DealerbaseUrl+"/login/"+dealeremail+"/"+dealerpassword)
  // }  


  FindDealerbyemail(data)
  {
    return this.http.get(this.DealerbaseUrl+"/list/"+data);
  }

  FindFarmerbyemail(data)
  {
    return this.http.get(this.FarmerbaseUrl+"/farmer/"+data);
  }

  FarmerRegister(data)
  {
    return this.http.post(this.FarmerbaseUrl+"/farmer/add",data)
  }

  FarmerLoginUser(data){
    return this.http.post(this.FarmerbaseUrl+"/farmerlogin",data)
  }

}
