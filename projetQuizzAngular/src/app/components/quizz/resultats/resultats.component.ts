import { Component, Input, OnInit } from "@angular/core";

@Component({
	selector: "app-resultats",
	templateUrl: "./resultats.component.html",
	styleUrls: ["./resultats.component.css"],
})
export class ResultatsComponent {
	@Input()
	score!: number;

	newLien: boolean = true;

	// ngOnInit(): void {
	// 	this.newLien = true;
	// 	console.log("ng on init" + this.newLien);
	// }

	newQuizz() {
		console.log(this.newLien);
		this.newLien = !this.newLien;
		console.log(this.newLien);
	}
}
