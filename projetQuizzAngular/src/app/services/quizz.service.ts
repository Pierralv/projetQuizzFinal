import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Question } from "../model/question";
import { questionRest, themeRest } from "../env";
import { Theme } from "../model/theme";
import { ObjectToJsonService } from "./object-to-json.service";

@Injectable({
	providedIn: "root",
})
export class QuizzService {
	constructor(private http: HttpClient, private convert: ObjectToJsonService) {}

	//themes
	public allThemes(): Observable<Theme[]> {
		return this.http.get<Theme[]>(themeRest);
	}

	public getQuestionByTheme(id: number): Observable<Theme> {
		return this.http.get<Theme>(`${themeRest}/${id}/questions`);
	}

	//questions
	public allQuestions(): Observable<Question[]> {
		return this.http.get<Question[]>(`${questionRest}/all`);
	}

	public getQuestionById(id: number): Observable<Question> {
		return this.http.get<Question>(`${questionRest}/${id}`);
	}

	public getQuestionByIdWithReponses(id: number): Observable<Question> {
		return this.http.get<Question>(`${questionRest}/${id}/reponses`);
	}

	// public create(question: Question): Observable<Question> {
	// 	return this.http.post<Question>(questionRest, this.convert.questionToJson(question));
	// }

	// public update(question: Question): Observable<Question> {
	// 	return this.http.put<Question>(
	// 		`${questionRest}/${question.id}`,
	// 		this.convert.questionToJson(question)
	// 	);
	// }

	public deleteById(id: number): Observable<void> {
		return this.http.delete<void>(`${questionRest}/${id}`);
	}
}
