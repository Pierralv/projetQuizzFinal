import { Component, EventEmitter, Output } from "@angular/core";
import { Router } from "@angular/router";
import { Question } from "src/app/model/question";
import { Theme } from "src/app/model/theme";
import { QuizzService } from "src/app/services/quizz.service";

@Component({
	selector: "app-prepa-quizz",
	templateUrl: "./prepa-quizz.component.html",
	styleUrls: ["./prepa-quizz.component.css"],
})
export class PrepaQuizzComponent {
	selectedTheme: Theme = new Theme();
	themes: Theme[] = [];
	nbQuestionQuizz!: number;

	@Output()
	sendQuestionsEven: EventEmitter<Question[]> = new EventEmitter();

	questionsByTheme: Question[] = [];
	questionForQuizz: Question[] = [];

	constructor(private quizzSrv: QuizzService, private router: Router) {}

	ngOnInit(): void {
		this.loadThemes();
	}

	loadThemes() {
		this.quizzSrv.getAllThemes().subscribe((themes: Theme[]) => {
			this.themes = themes;
		});
	}

	sendPrepQuizz() {
		this.quizzSrv
			.getQuestionRandomByTheme(Number(this.selectedTheme))
			.subscribe((questions: Question[]) => {
				this.questionsByTheme = questions;
				this.questionForQuizz = this.questionsByTheme.slice(0, this.nbQuestionQuizz);
				this.sendQuestionsEven.emit(this.questionForQuizz);
				// console.log(this.questionsByTheme);
				// console.log(this.questionForQuizz);
			});
	}
}
