import { QuizzService } from "src/app/services/quizz.service";
import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Question } from "src/app/model/question";
import { Reponse } from "src/app/model/reponse";

@Component({
	selector: "app-question",
	templateUrl: "./question.component.html",
	styleUrls: ["./question.component.css"],
})
export class QuestionComponent {
	@Input()
	numero: number;

	@Input()
	question: Question;

	@Input()
	showQuestion: boolean;

	@Output()
	showQuestionEven: EventEmitter<boolean> = new EventEmitter();

	value!: string;
	bonneReponse!: Reponse;

	constructor(private quizzSrv: QuizzService) {}

	getValue(ev: Event) {
		this.value = (ev.target as HTMLInputElement).value;
		console.log(this.value);
		// if (this.value == "true") {
		// 	console.log("if vrai");
		// } else {
		// 	console.log("else");
		// }
	}

	voirResults() {
		this.showQuestion = false;
		this.showQuestionEven.emit(this.showQuestion);
		this.question.reponses.forEach((rep) => {
			if (rep.bonneReponse) this.bonneReponse = rep;
		});
		console.log(this.bonneReponse);
	}
}
