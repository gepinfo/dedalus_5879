import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';


@Injectable({
    providedIn: 'root'
})

export class HospitalorderlistService {
    constructor(
        private http: HttpClient,
    ) { }


  BaseURL = environment.WEB_API;


  PostAllhospitalorderlistValues(data:any){
    return this.http.post(`${this.BaseURL}/hospitalorderlist`,data);
  }

  GetAllhospitalorderlistValues(){
    return this.http.get(`${this.BaseURL}/hospitalorderlist`);
  }

  Updatehospitalorderlist(data:any){
    return this.http.put(`${this.BaseURL}/hospitalorderlist/${data.id}`,data);
  }

  getSpecifichospitalorderlist(id:number){
    return this.http.get(`${this.BaseURL}/hospitalorderlist/${id}`);
  }

  getSpecifichospitalorderlistHistory(id:number){
    return this.http.get(`${this.BaseURL}/hospitalorderlist/${id}/history?days=30`);
  }

  DeletehospitalorderlistValues(dataId:any){
     return this.http.delete(`${this.BaseURL}/hospitalorderlist/${dataId}`);
  }

  GetEntityById(hospitalorderlistId:any): Observable<any> {
    return this.http.get(`${this.BaseURL}/hospitalorderlistid/` + hospitalorderlistId);
  }

  Searchhospitalorderlist(data:any): Observable<any> {
    const temp:any = [];
    const objectKeyPair = Object.entries(data);
    objectKeyPair.forEach((element, index) => {
    if (element[1]) {
    temp.push(`${element[0]}=${element[1]}`);
    }
    });
    let jwt_token = sessionStorage.getItem('JwtToken');
    return this.http.get(`${this.BaseURL}` + `/hospitalorderlist/get/search?jwt_token=${jwt_token}${temp.length > 0 ? `&${temp.join('&')}` : ''}`);
  }
}