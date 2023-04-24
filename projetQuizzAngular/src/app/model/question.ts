import { Compte } from "./compte";
import { Reponse } from "./reponse";
import { Theme } from "./theme";

export class Question {
	public get createur(): Compte | undefined {
		return this._createur;
	}
	public set createur(value: Compte | undefined) {
		this._createur = value;
	}
	public get reponses(): Set<Reponse> | undefined {
		return this._reponses;
	}
	public set reponses(value: Set<Reponse> | undefined) {
		this._reponses = value;
	}
	public get theme(): Theme | undefined {
		return this._theme;
	}
	public set theme(value: Theme | undefined) {
		this._theme = value;
	}
	public get enonceQuestion(): string | undefined {
		return this._enonceQuestion;
	}
	public set enonceQuestion(value: string | undefined) {
		this._enonceQuestion = value;
	}
	public get id(): number | undefined {
		return this._id;
	}
	public set id(value: number | undefined) {
		this._id = value;
	}
	constructor(
		private _id?: number,
		private _enonceQuestion?: string,
		private _theme?: Theme,
		private _reponses?: Set<Reponse>,
		private _createur?: Compte
	) {}
}
