import { Role } from "./role";

export class Compte {
  public get role(): Role | undefined{
    return this._role;
  }
  public set role(value: Role| undefined) {
    this._role = value;
  }
  public get email(): string | undefined{
    return this._email;
  }
  public set email(value: string| undefined) {
    this._email = value;
  }
  public get avatar(): string | undefined{
    return this._avatar;
  }
  public set avatar(value: string| undefined) {
    this._avatar = value;
  }
  public get pseudo(): string | undefined{
    return this._pseudo;
  }
  public set pseudo(value: string| undefined) {
    this._pseudo = value;
  }
  public get prenom(): string | undefined{
    return this._prenom;
  }
  public set prenom(value: string| undefined) {
    this._prenom = value;
  }
  public get nom(): string | undefined{
    return this._nom;
  }
  public set nom(value: string| undefined) {
    this._nom = value;
  }
  public get id(): number | undefined{
    return this._id;
  }
  public set id(value: number| undefined) {
    this._id = value;
  }
  constructor(private _id?: number,
    private _nom?: string,
    private _prenom?: string,
    private _pseudo?: string,
    private _avatar?: string,
    private _email?: string,
    private _role?: Role
    ) {}
}
