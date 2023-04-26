import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { Role } from 'src/app/model/role';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  constructor(private router: Router){}

  compte:Compte;

  ngOnInit(): void {
    this.initCompte();
  }

  initCompte() {
    if (sessionStorage.getItem('compte')) {
      this.compte = JSON.parse(sessionStorage.getItem('compte')!) as Compte;
    }
  }

  deconnexion() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  get connecte(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  get admin(): boolean {
    if (sessionStorage.getItem('compte')) {
      let compte: Compte = JSON.parse(
        sessionStorage.getItem('compte')!
      ) as Compte
      return compte.role == Role.ROLE_ADMIN;
    }
    return false;
  }
get utilisateur(): boolean {
  if (sessionStorage.getItem('compte')) {
    let compte: Compte = JSON.parse(
      sessionStorage.getItem('compte')!
    ) as Compte;
    return compte.role == Role.ROLE_UTILISATEUR;
  }
  return false
}

}
