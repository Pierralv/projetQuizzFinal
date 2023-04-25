import { Injectable } from "@angular/core";
import { Question } from "../model/question";

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
}
