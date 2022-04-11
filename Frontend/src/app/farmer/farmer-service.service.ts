import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FarmerServiceService {
  private ProductbaseUrl="http://localhost:8001/product";
  private FarmerbaseUrl="http://localhost:8003/farmer";
  constructor( private http:HttpClient ) { }


  farmerbyemail(email)
  {
    return this.http.get(this.FarmerbaseUrl+"/farmer/"+email);
  }

  farmerupdata(email,data)
  {
    return this.http.put(this.FarmerbaseUrl+"/list/"+email,data)
  }

  getproductbyid(email)
  {
    return this.http.get(this.ProductbaseUrl+"/farmer/"+email);
  }

  addproductbyemail(data)
  {
    return this.http.post(this.ProductbaseUrl+"/list/add",data);
  }

  updateproduct(id,data)
  {
    return this.http.put(this.ProductbaseUrl+"/list/"+id,data);
  }

  deleteproduct(id)
  {
    return this.http.delete(this.ProductbaseUrl+"/list/"+id);
  }
  
}
