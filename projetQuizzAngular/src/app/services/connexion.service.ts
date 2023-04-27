import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Compte } from "../model/compte";
import { authRest } from "../env";

@Injectable({
	providedIn: "root",
})
export class ConnexionService {
	constructor(private http: HttpClient) {}

	public connexion(pseudo: string, motDePasse: string): Observable<Compte> {
		let headers: HttpHeaders = new HttpHeaders({
			Authorization: "Basic " + window.btoa(pseudo + ":" + motDePasse),
		});
		return this.http.get<Compte>(authRest, { headers: headers });
	}
}
