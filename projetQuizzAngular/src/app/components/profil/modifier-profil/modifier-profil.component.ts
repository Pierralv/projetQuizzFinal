import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Compte } from 'src/app/model/compte';

@Component({
  selector: 'app-modifier-profil',
  templateUrl: './modifier-profil.component.html',
  styleUrls: ['./modifier-profil.component.css'],
})
export class ModifierProfilComponent {
  @Input()
  compte!: Compte;

  prenom!:string;

  showError = false;

  modifier(form: NgForm) {
    console.log(this.compte);
  }
}
