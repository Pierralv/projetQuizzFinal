import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Question } from "../model/question";
import { questionRest, reponseRest, themeRest } from "../env";
import { Theme } from "../model/theme";
import { ObjectToJsonService } from "./object-to-json.service";
import { Reponse } from "../model/reponse";

@Injectable({
	providedIn: "root",
})
export class QuizzService {
	constructor(private http: HttpClient, private convert: ObjectToJsonService) {}

	//themes
	public getAllThemes(): Observable<Theme[]> {
		return this.http.get<Theme[]>(themeRest);
	}

	public getQuestionByTheme(id: number): Observable<Theme> {
		return this.http.get<Theme>(`${themeRest}/${id}/questions`);
	}

	//questions
	public getAllQuestions(): Observable<Question[]> {
		return this.http.get<Question[]>(`${questionRest}/all`);
	}

	public getAllQuestionsRandom(): Observable<Question[]> {
		return this.http.get<Question[]>(`${questionRest}/all/random`);
	}

	public getQuestionRandomByTheme(id: number): Observable<Question[]> {
		return this.http.get<Question[]>(`${themeRest}/${id}/questions/random`);
	}

	public getQuestionById(id: number): Observable<Question> {
		return this.http.get<Question>(`${questionRest}/${id}`);
	}

	public getQuestionByIdWithReponses(id: number): Observable<Question> {
		return this.http.get<Question>(`${questionRest}/${id}/reponses`);
	}

	public createQuestion(question: any): Observable<any> {
		return this.http.post(questionRest, question);
	}

  public deleteQuestion(id:number): Observable<void>{
    return this.http.delete<void>(`${questionRest}/${id}`)
  }

	// public update(question: Question): Observable<Question> {
	// 	return this.http.put<Question>(
	// 		`${questionRest}/${question.id}`,
	// 		this.convert.questionToJson(question)
	// 	);
	// }

	public deleteById(id: number): Observable<void> {
		return this.http.delete<void>(`${questionRest}/${id}`);
	}

	//reponses

  public createReponse(reponse:any): Observable<any>{
    return this.http.post(reponseRest, reponse);
  }

	public getReponseById(id: number): Observable<Reponse> {
		return this.http.get<Reponse>(`${reponseRest}/${id}/questionreponses`);
	}
}
