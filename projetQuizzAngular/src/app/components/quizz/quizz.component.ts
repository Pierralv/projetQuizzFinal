import { Component, Input, OnInit } from "@angular/core";
import { Question } from "src/app/model/question";

@Component({
	selector: "app-quizz",
	templateUrl: "./quizz.component.html",
	styleUrls: ["./quizz.component.css"],
})
export class QuizzComponent implements OnInit {
	questionsQuizz: Question[] = [];
	nbQuestionQuizz: number;
	index: number = 0;
	showPrepaQuizz: boolean = true;
	showQuestion: boolean;

	constructor() {}

	ngOnInit(): void {
		this.showQuestion = true;
	}

	loadQuestionsQuizz(questions: Question[]) {
		this.questionsQuizz = questions;
		this.showPrepaQuizz = false;
		this.nbQuestionQuizz = this.questionsQuizz.length;
	}

	questionSuivante() {
		this.index++;
		this.showQuestion = true;
	}

	traitementBoolean(showQuestion: boolean) {
		this.showQuestion = showQuestion;
	}
}
