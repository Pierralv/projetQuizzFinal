import { CompteServiceService } from "src/app/services/compte-service.service";
import { Component, OnInit } from "@angular/core";
import { Question } from "src/app/model/question";
import { Compte } from "src/app/model/compte";

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
	compte!: Compte;

	constructor(private compteSrv: CompteServiceService) {}

	ngOnInit(): void {
		this.showQuestion = true;

		//recup compte si connexion
		if (sessionStorage.getItem("compte")) {
			this.compte = JSON.parse(sessionStorage.getItem("compte")!) as Compte;
		}
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
		this.score = (this.points / this.nbQuestionQuizz) * 10;
	}

	finQuizz() {
		this.showResultats = true;
		//si compte ds session
		if (sessionStorage.getItem("compte")) {
			let compteSession: Compte = JSON.parse(sessionStorage.getItem("compte")!) as Compte;
			let scoreMaxCompteSession: number = compteSession.statistique.scoreMax;
			if (scoreMaxCompteSession < this.score) {
				//save nouveau score
				this.compte.statistique.scoreMax = this.score;
			}

			let scoreMoyenCompteSession: number = compteSession.statistique.scoreMoyen;
			if (scoreMoyenCompteSession == 0) {
				this.compte.statistique.scoreMoyen = this.score;
			} else {
				this.compte.statistique.scoreMoyen = (scoreMoyenCompteSession + this.score) / 2;
			}
			this.compteSrv.modification(this.compte).subscribe(() => {
				sessionStorage.setItem("compte", JSON.stringify(this.compte));
			});
		}
	}
}
