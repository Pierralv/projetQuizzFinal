import { Injectable } from "@angular/core";
import { Question } from "../model/question";
import { Compte } from "../model/compte";

@Injectable({
	providedIn: "root",
})
export class ObjectToJsonService {
	constructor() {}

	public questionToJson(question: Question): any {
		let obj = {
			enonceQuestion: question.enonceQuestion,
		};
		if (question.id) {
			Object.assign(obj, { id: question.id });
		}
	}

	public compteToJson(compte: Compte): any {
		let obj = {
			prenom: compte.prenom,
			nom: compte.nom,
			email: compte.email,
			avatar: compte.avatar,
			statistique: {
				scoreMax: compte.statistique.scoreMax,
				scoreMoyen: compte.statistique.scoreMoyen,
			},
		};
		if (compte.id) {
			Object.assign(obj, { id: compte.id });
		}
		return obj;
	}
}
