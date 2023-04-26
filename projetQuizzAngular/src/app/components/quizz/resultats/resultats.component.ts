import { Component, Input } from "@angular/core";

@Component({
	selector: "app-resultats",
	templateUrl: "./resultats.component.html",
	styleUrls: ["./resultats.component.css"],
})
export class ResultatsComponent {
	@Input()
	score!: number;
}
