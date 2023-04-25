import { Component, Output } from "@angular/core";
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
	selectedTheme!: Theme;
	themes: Theme[] = [];

	questionsByTheme: Question[] = [];

	constructor(private quizzSrv: QuizzService, private router: Router) {}

	ngOnInit(): void {
		this.loadThemes();
	}

	loadThemes() {
		this.quizzSrv.allThemes().subscribe((themes: Theme[]) => {
			this.themes = themes;
		});
	}

	selected() {
		this.quizzSrv.getQuestionByTheme(this.selectedTheme.id).subscribe((theme: Theme) => {
			this.questionsByTheme = theme.questions;
		});
		console.log(this.questionsByTheme);
	}
}
