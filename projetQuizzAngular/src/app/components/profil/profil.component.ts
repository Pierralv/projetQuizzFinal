import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { CompteServiceService } from 'src/app/services/compte-service.service';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})

export class ProfilComponent implements OnInit {

  constructor(private compteSrv:CompteServiceService, private router:Router){}

  warning=false;
  compte!:Compte;

  ngOnInit(): void {
    this.initCompte();
  }

  initCompte() {
    if (sessionStorage.getItem('compte')) {
      this.compte = JSON.parse(sessionStorage.getItem('compte')!) as Compte;
    }
  }

  showWarning(){
    this.warning = !this.warning;
  }

  suppression(id: number) {
    this.compteSrv.suppression(id).subscribe(() => {
      sessionStorage.clear();
      this.router.navigateByUrl('/home');
    });
  }
}
