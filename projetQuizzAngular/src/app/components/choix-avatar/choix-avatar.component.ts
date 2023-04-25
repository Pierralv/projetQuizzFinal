import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Compte } from 'src/app/model/compte';

@Component({
  selector: 'app-choix-avatar',
  templateUrl: './choix-avatar.component.html',
  styleUrls: ['./choix-avatar.component.css']
})
export class ChoixAvatarComponent {

  @Input()
  compte!:Compte;

  @Input()
  avatar!:string;

  changerAvatar(chemin:string){
    this.compte.avatar=chemin;
  }

  changerAvatarString(chemin:string){
    this.avatar = chemin;
  }

}
