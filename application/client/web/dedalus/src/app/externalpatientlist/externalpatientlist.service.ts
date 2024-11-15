import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
    providedIn: 'root'
})

export class ExternalpatientlistService {
    constructor(
        private http: HttpClient,
    ) { }


  BaseURL = environment.WEB_API;


  PostAllexternalpatientlistValues(data:any){
    return this.http.post(`${this.BaseURL}/externalpatientlist`,data);
  }

  GetAllexternalpatientlistValues(){
    return this.http.get(`${this.BaseURL}/externalpatientlist`);
  }

  Updateexternalpatientlist(data:any){
    return this.http.put(`${this.BaseURL}/externalpatientlist/${data.id}`,data);
  }

  getSpecificexternalpatientlist(id:number){
    return this.http.get(`${this.BaseURL}/externalpatientlist/${id}`);
  }

  getSpecificexternalpatientlistHistory(id:number){
    return this.http.get(`${this.BaseURL}/externalpatientlist/${id}/history?days=30`);
  }

  DeleteexternalpatientlistValues(dataId:any){
     return this.http.delete(`${this.BaseURL}/externalpatientlist/${dataId}`);
  }

  GetEntityById(externalpatientlistId:any): Observable<any> {
    return this.http.get(`${this.BaseURL}/externalpatientlistid/` + externalpatientlistId);
  }

  Searchexternalpatientlist(data:any): Observable<any> {
    const temp:any = [];
    const objectKeyPair = Object.entries(data);
    objectKeyPair.forEach((element, index) => {
    if (element[1]) {
    temp.push(`${element[0]}=${element[1]}`);
    }
    });
    let jwt_token = sessionStorage.getItem('JwtToken');
    return this.http.get(`${this.BaseURL}` + `/externalpatientlist/get/search?jwt_token=${jwt_token}${temp.length > 0 ? `&${temp.join('&')}` : ''}`);
  }
}