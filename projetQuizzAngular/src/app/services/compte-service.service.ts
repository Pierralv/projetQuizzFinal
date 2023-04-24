import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { compteRest } from '../env';

@Injectable({
  providedIn: 'root',
})
export class CompteServiceService {
  constructor(private http: HttpClient) {}

  public inscription(compte: any): Observable<any> {
    return this.http.post(compteRest + '/inscription', compte);
  }

  public checkPseudo(pseudo: string): Observable<any> {
    return this.http.get<boolean>(compteRest + '/pseudo/check/' + pseudo);
  }

  public suppression(id: number): Observable<any> {
    return this.http.delete<void>(compteRest + `/${id}`)
  }
}
