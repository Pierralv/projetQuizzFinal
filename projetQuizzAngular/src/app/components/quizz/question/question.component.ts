import { QuizzService } from "src/app/services/quizz.service";
import { Component, EventEmitter, Input, Output } from "@angular/core";
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

	@Output()
	sendPtsEven: EventEmitter<number> = new EventEmitter();

	value!: string;
	bonneReponse!: Reponse;
	points: number = 0;

	getValue(ev: Event) {
		this.value = (ev.target as HTMLInputElement).value;
	}

	voirResults() {
		this.showQuestion = false;
		this.showQuestionEven.emit(this.showQuestion);
		this.question.reponses.forEach((rep) => {
			if (rep.bonneReponse) this.bonneReponse = rep;
		});
		if (this.value == "true") {
			this.points++;
		} else {
			if (this.points >= 0.5) {
				this.points = this.points - 0.5;
			}
		}
		this.sendPtsEven.emit(this.points);
	}
}
