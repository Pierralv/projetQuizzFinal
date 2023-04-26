import { QuizzService } from "src/app/services/quizz.service";
import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Question } from "src/app/model/question";

@Component({
	selector: "app-question",
	templateUrl: "./question.component.html",
	styleUrls: ["./question.component.css"],
})
export class QuestionComponent {
	value!: string;
	bonneReponse!: boolean;

	@Input()
	numero: number;

	@Input()
	question: Question;

	@Input()
	showQuestion: boolean;

	@Output()
	showQuestionEven: EventEmitter<boolean> = new EventEmitter();

	constructor(private quizzSrv: QuizzService) {}

	getValue(ev: Event) {
		this.value = (ev.target as HTMLInputElement).value;
		if (this.value) {
		}
	}

	voirResults() {
		this.showQuestion = false;
		this.showQuestionEven.emit(this.showQuestion);
	}
}
