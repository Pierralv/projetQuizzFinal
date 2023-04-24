import { Question } from "./question";

export class Reponse {
	public get question(): Question | undefined {
		return this._question;
	}
	public set question(value: Question | undefined) {
		this._question = value;
	}
	public get bonneReponse(): boolean | undefined {
		return this._bonneReponse;
	}
	public set bonneReponse(value: boolean | undefined) {
		this._bonneReponse = value;
	}
	public get enonceReponse(): string | undefined {
		return this._enonceReponse;
	}
	public set enonceReponse(value: string | undefined) {
		this._enonceReponse = value;
	}
	public get id(): number | undefined {
		return this._id;
	}
	public set id(value: number | undefined) {
		this._id = value;
	}
	constructor(
		private _id?: number,
		private _enonceReponse?: string,
		private _bonneReponse?: boolean,
		private _question?: Question
	) {}
}
