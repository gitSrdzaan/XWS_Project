import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import RentAdvert from '../_model/rentAdvert.model';
import { of } from 'rxjs';
import SearchInfo from '../_model/searchInfo.model';

@Injectable()
export class SearchService {
  constructor(private http: HttpClient) {}

  search(searchInfo: SearchInfo) {
    //replace this with real api
    //something like this
    //return this.http.post<any>("ADD_URL/podaci", searchInfo);

    let token = localStorage.getItem('token');
    if (token === null) return;
    return this.http.post<Array<RentAdvert>>(
      `http://localhost:8089/search/pretrazivanje/podaci`,
      { searchInfo },
      {
        headers: { 'x-auth': `Bearer ${token}` },
      }
    );

    const mocked: RentAdvert[] = [];
    return of(mocked);
  }
}
