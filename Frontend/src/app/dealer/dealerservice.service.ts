import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

function _window() : any {
  
  return window;
}

@Injectable({
  providedIn: 'root'
})
export class DealerserviceService {

  get nativeWindow() : any {
    return _window();
 }

  private ProductbaseUrl="http://localhost:8001/product";
  private DealerbaseUrl="http://localhost:8002/dealer";
  private FarmerbaseUrl="http://localhost:8003/farmer";
  private TransbaseUrl="http://localhost:8006/transaction";
  constructor(private http:HttpClient) { }

  productList()
  {
    return this.http.get(this.ProductbaseUrl+"/list");
  }

  Dealerordercreate(data)
  {
    return this.http.post(this.DealerbaseUrl+"/order/create",data);
  }

  Dealerorderlist(data)
  {
    return this.http.get(this.DealerbaseUrl+"/order/"+data);
  }

  dealerbyemail(data)
  {
    return this.http.get(this.DealerbaseUrl+"/list/"+data)
  }

  dealerupdata(email,data)
  {
    return this.http.put(this.DealerbaseUrl+"/list/"+email,data);
  }

  createTran(data)
  {
    return this.http.post(this.TransbaseUrl+"/create",data);
  }

  updateTran(data)
  {
    return this.http.put(this.TransbaseUrl+"/update/",data);
  }

  getalltran()
  {
    return this.http.get(this.TransbaseUrl+"/list");
  }

  getfarmerdata(email)
  {
    return this.http.get(this.FarmerbaseUrl+"/farmer/"+email);
  }

}
