import { Component, OnInit } from "@angular/core";
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
	showResultats: boolean = false;
	boutonSuite: boolean = true;
	points!: number;
	score!: number;

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
		if (this.index == this.questionsQuizz.length - 1) {
			this.boutonSuite = false;
		}
	}

	traitementBoolean(showQuestion: boolean) {
		this.showQuestion = showQuestion;
	}

	traitementPts(pointsQuest: number) {
		this.points = pointsQuest;
		console.log(this.points);
		this.score = (this.points / this.nbQuestionQuizz) * 10;
		console.log(this.score);
	}

	finQuizz() {
		this.showResultats = true;
	}
}
