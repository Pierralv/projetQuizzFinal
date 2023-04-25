import { Component, Input, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Question } from "src/app/model/question";
import { Theme } from "src/app/model/theme";
import { QuizzService } from "src/app/services/quizz.service";

@Component({
	selector: "app-quizz",
	templateUrl: "./quizz.component.html",
	styleUrls: ["./quizz.component.css"],
})
export class QuizzComponent implements OnInit {
	allQuestions: Question[] = [];

	@Input()
	questions: Question[] = [];

	constructor(private quizzSrv: QuizzService, private router: Router) {}

	ngOnInit(): void {
		this.loadQuestions();
		console.log(this.questions);
	}

	loadQuestions() {
		this.quizzSrv.allQuestions().subscribe((allQuestions: Question[]) => {
			this.allQuestions = allQuestions;
		});
	}
}
