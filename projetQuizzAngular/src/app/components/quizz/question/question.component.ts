import { QuizzService } from "src/app/services/quizz.service";
import { Component, Input, OnInit } from "@angular/core";
import { Question } from "src/app/model/question";
import { Reponse } from "src/app/model/reponse";

@Component({
	selector: "app-question",
	templateUrl: "./question.component.html",
	styleUrls: ["./question.component.css"],
})
export class QuestionComponent implements OnInit {
	// @Input("questionsQuizz")
	// questions: Question[];
	showResults = false;
	value: boolean;

	@Input()
	numero: number;

	@Input()
	question: Question;

	// nbQuestionQuizz!: number;

	constructor(private quizzSrv: QuizzService) {}

	ngOnInit(): void {
		// this.nbQuestionQuizz = this.questions.length;
		// console.log(this.questions);
	}

	voirResults(ev: Event) {
		this.showResults = true;
		console.log((ev.target as HTMLInputElement).value);
		// this.quizzSrv.getReponseById();
	}
}
