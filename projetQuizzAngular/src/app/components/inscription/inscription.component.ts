import { Component, OnInit } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { Compte } from 'src/app/model/compte';
import { CompteServiceService } from 'src/app/services/compte-service.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  constructor(private compteSrv: CompteServiceService, private router: Router) {}
  form!: FormGroup;
  showPassword = false;
  avatar: string = 'assets/img/avatarVide.png';

  ngOnInit(): void {
    this.form = new FormGroup({
      prenom: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      compteGroup: new FormGroup({
        pseudo: new FormControl('', Validators.required,this.pseudoDispo(this.compteSrv)),
        mdpGroup: new FormGroup({
          mdp: new FormControl('', Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$/)),
          mdpConfirm: new FormControl(''),
        },this.mdpEgaux),
      },
      this.pseudoEtMdpDifferents),
    });
  }

  pseudoDispo(srv: CompteServiceService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.compteSrv.checkPseudo(control.value).pipe(
        map((exist: boolean) => {
          return exist ? {pseudoAlreadyExist: true} :null;
        })
      );
    };
  }

  mdpEgaux(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if(group.get('mdp')?.invalid){
      return null;
    }
    return group.get('mdp')?.value == group.get('mdpConfirm')?.value ? null : {mdpEgaux: true};
  }

  pseudoEtMdpDifferents(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if(group.get('pseudo')?.invalid){
      return null;
    }
    return group.get('pseudo')?.value != group.get('mdp')?.value ? null : {pseudoEtMdpDifferents: true};
  }

  submit() {
    let compteJson = {
      prenom: this.form.get('prenom')?.value,
      nom: this.form.get('nom')?.value,
      pseudo: this.form.get('compteGroup.pseudo')?.value,
      email: this.form.get('email')?.value,
      motDePasse: this.form.get('compteGroup.mdpGroup.mdp')?.value,
      avatar: this.avatar,
    };
    this.compteSrv.inscription(compteJson).subscribe((compte) => {
      this.router.navigateByUrl('/connexion');
    })
  }

  show(){
    this.showPassword = !this.showPassword;
    console.log(this.showPassword);
  }

  traitementAvatarInscription(avatar: string) {
    this.avatar = avatar;
  }
}
