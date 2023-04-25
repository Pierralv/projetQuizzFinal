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

  @Output()
  AvatarCompteEvent: EventEmitter<string> = new EventEmitter();

  @Output()
  AvatarStringEvent: EventEmitter<string> = new EventEmitter();

  changerAvatar(chemin:string){
    this.compte.avatar=chemin;
    this.AvatarCompteEvent.emit(this.compte.avatar);
  }
  
  changerAvatarString(chemin:string){
    this.avatar = chemin;
    this.AvatarStringEvent.emit(this.avatar);
  }
}
