import { Question } from "./question";

export class Theme {
	public get questions(): Question[] | undefined {
		return this._questions;
	}
	public set questions(value: Question[] | undefined) {
		this._questions = value;
	}
	public get nom(): string | undefined {
		return this._nom;
	}
	public set nom(value: string | undefined) {
		this._nom = value;
	}
	public get id(): number | undefined {
		return this._id;
	}
	public set id(value: number | undefined) {
		this._id = value;
	}
	constructor(private _id?: number, private _nom?: string, private _questions?: Question[]) {}
}
