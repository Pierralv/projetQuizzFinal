import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Compte } from 'src/app/model/compte';
import { Role } from 'src/app/model/role';
import { ConnexionService } from 'src/app/services/connexion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent {
  pseudo: string='';
  motDePasse: string ='';
  showError = false;
  showPassword= false;
  constructor(private connexionSrv: ConnexionService, private router: Router) {}

  check(form: NgForm) {
    if(form.valid) {
      this.connexionSrv.connexion(this.pseudo,this.motDePasse).subscribe({
        next: (infos: Compte) => {
          this.showError =false;
          sessionStorage.setItem('token','Basic ' +window.btoa(this.pseudo + ':'+ this.motDePasse));
          sessionStorage.setItem('compte', JSON.stringify(infos));
          if(infos.role == Role.ROLE_UTILISATEUR){
            this.router.navigateByUrl('/home');
          } else {
            this.router.navigateByUrl('/admin');
          }
        },
        error: (error: any) => {
          this.showError = true;
        },
      });
    }
  }

  show(){
    this.showPassword = !this.showPassword;
  }

}
