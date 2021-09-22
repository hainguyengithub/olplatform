import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SERVER_BASE_URL, API_PROGRAMS } from 'src/app/constants';
import { Program } from '../Program';

@Injectable({
  providedIn: 'root',
})
export class ProgramService {
  public resourceUrl: string;

  constructor(private httpClient: HttpClient) {
    this.resourceUrl = `${SERVER_BASE_URL}/${API_PROGRAMS}`;
  }

  load(): Observable<Program[]> {
    return this.httpClient.get<Program[]>(this.resourceUrl);
  }
}
