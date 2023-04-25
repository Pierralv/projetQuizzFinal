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
  AvatarEvent: EventEmitter<string> = new EventEmitter();


  changerAvatar(chemin:string){
    if(this.compte){
      this.compte.avatar=chemin;
      this.AvatarEvent.emit(this.compte.avatar);
    } else {
      this.avatar = chemin;
      this.AvatarEvent.emit(this.avatar)
    }
  }

}
