import { ObjectToJsonService } from './object-to-json.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { compteRest } from '../env';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root',
})
export class CompteServiceService {
  constructor(private http: HttpClient, private convert: ObjectToJsonService) {}

  public inscription(compte: any): Observable<any> {
    return this.http.post(compteRest + '/inscription', compte);
  }

  public checkPseudo(pseudo: string): Observable<any> {
    return this.http.get<boolean>(compteRest + '/pseudo/check/' + pseudo);
  }

  public suppression(id: number): Observable<any> {
    return this.http.delete<void>(compteRest + `/${id}`)
  }

  public modification(compte: Compte): Observable<Compte>{
    return this.http.put<Compte>(
      `${compteRest}/${compte.id}`,
      this.convert.compteToJson(compte)
    );
  }
}
