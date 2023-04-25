import { Component, Input, OnInit } from "@angular/core";
import { Question } from "src/app/model/question";

@Component({
	selector: "app-quizz",
	templateUrl: "./quizz.component.html",
	styleUrls: ["./quizz.component.css"],
})
export class QuizzComponent implements OnInit {
	questionsQuizz: Question[] = [];
	nbQuestionQuizz!: number;
	showPrepaQuizz: boolean = true;

	constructor() {}

	ngOnInit(): void {}

	loadQuestionsQuizz(questions: Question[]) {
		this.questionsQuizz = questions;
		this.nbQuestionQuizz = this.questionsQuizz.length;
		console.log(this.questionsQuizz);
		console.log(this.nbQuestionQuizz);
		this.showPrepaQuizz = false;
	}
}
