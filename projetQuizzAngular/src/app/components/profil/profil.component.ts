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
  modif=false;
  compte!:Compte;
  messageSuppression=false;

  ngOnInit(): void {
    this.initCompte();
    console.log(this.compte);
  }

  initCompte() {
    if (sessionStorage.getItem('compte')) {
      this.compte = JSON.parse(sessionStorage.getItem('compte')!) as Compte;
    }
  }

  showWarning(){
    this.warning = !this.warning;
  }

  showModif(){
    this.modif = !this.modif
  }

  traitementModifBoolean(modif: boolean){
    this.modif = modif;
  }

  suppression(id: number) {
    this.messageSuppression = true;
    setTimeout(()=>{
      this.compteSrv.suppression(id).subscribe(() => {
        sessionStorage.clear();
        this.router.navigateByUrl('/home');
      });
    }
    ,1000);
  }
}
