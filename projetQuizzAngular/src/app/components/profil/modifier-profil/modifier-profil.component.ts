import { Router } from '@angular/router';
import { CompteServiceService } from 'src/app/services/compte-service.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Compte } from 'src/app/model/compte';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-modifier-profil',
  templateUrl: './modifier-profil.component.html',
  styleUrls: ['./modifier-profil.component.css'],
})
export class ModifierProfilComponent {
  constructor(
    private compteSrv: CompteServiceService,
    private router: Router
  ) {}

  @Input()
  compte!: Compte;

  @Output()
  modifBooleanEvent: EventEmitter<boolean> = new EventEmitter()

  prenom!: string;

  showError = false;

  modifier(form: NgForm) {
    if (form.valid) {
      this.compteSrv.modification(this.compte).subscribe({
        next:()=>{
          this.showError = false;
          sessionStorage.setItem('compte', JSON.stringify(this.compte));
          this.modifBooleanEvent.emit(false)
        },
        error:() => {
          this.showError = true;
        }
      });
    }
  }

  traitementAvatar(avatar: string) {
    this.compte.avatar = avatar;
  }
}
