export class Statistiques {
	public get scoreMoyen(): number | undefined {
		return this._scoreMoyen;
	}
	public set scoreMoyen(value: number | undefined) {
		this._scoreMoyen = value;
	}
	public get scoreMax(): number | undefined {
		return this._scoreMax;
	}
	public set scoreMax(value: number | undefined) {
		this._scoreMax = value;
	}
	constructor(private _scoreMax?: number, private _scoreMoyen?: number) {}
}
