import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Theme } from 'src/app/model/theme';
import { QuizzService } from 'src/app/services/quizz.service';

@Component({
  selector: 'app-edit-modif-quizz',
  templateUrl: './edit-modif-quizz.component.html',
  styleUrls: ['./edit-modif-quizz.component.css'],
})
export class EditModifQuizzComponent implements OnInit {
  constructor(private quizzSrv: QuizzService, private router: Router) {}

  form: FormGroup;
  bonneReponseA:boolean = true;
  bonneReponseB:boolean = false;
  bonneReponseC:boolean = false;
  bonneReponseD:boolean = false;
  themes: Theme[] = [];
  selectedTheme: Theme = new Theme();

  ngOnInit(): void {
    this.form = new FormGroup({
      theme: new FormControl('', Validators.required),
      enonceQuestion: new FormControl('', Validators.required),
      reponseA: new FormControl('', Validators.required),
      reponseB: new FormControl('', Validators.required),
      reponseC: new FormControl('', Validators.required),
      reponseD: new FormControl('', Validators.required),
      // bonneReponse: new FormControl('', Validators.required),
    });
    this.loadThemes();
  }

  loadThemes() {
    this.quizzSrv.getAllThemes().subscribe((themes: Theme[]) => {
      this.themes = themes;
    });
  }

  changeReponseA(ev : Event) {
      this.bonneReponseA = true
      this.bonneReponseB = false
      this.bonneReponseC = false
      this.bonneReponseD = false
  }

  changeReponseB(ev : Event) {
      this.bonneReponseB = true
      this.bonneReponseA = false
      this.bonneReponseC = false
      this.bonneReponseD = false
  }

  changeReponseC(ev : Event) {
      this.bonneReponseB = false
      this.bonneReponseA = false
      this.bonneReponseC = true
      this.bonneReponseD = false
  }

  changeReponseD(ev : Event) {
    this.bonneReponseB = false
    this.bonneReponseA = false
    this.bonneReponseC = false
    this.bonneReponseD = true
  }

  submit() {
    let questionJson = {
      enonceQuestion: this.form.get('enonceQuestion').value,
      theme: this.form.get('theme').value,
    };
    this.quizzSrv.createQuestion(questionJson).subscribe((resp) => {
      let reponseAJson = {
        enonceReponse: this.form.get('reponseA').value,
        bonneReponse: this.bonneReponseA,
        question: resp
      };
      let reponseBJson = {
        enonceReponse: this.form.get('reponseB').value,
        bonneReponse: this.bonneReponseB,
        question: resp
      };
      let reponseCJson = {
        enonceReponse: this.form.get('reponseC').value,
        bonneReponse: this.bonneReponseC,
        question: resp
      };
      let reponseDJson = {
        enonceReponse: this.form.get('reponseD').value,
        bonneReponse: this.bonneReponseD,
        question: resp
      };
      this.quizzSrv.createReponse(reponseAJson).subscribe(() => {
      });
      this.quizzSrv.createReponse(reponseBJson).subscribe(() => {
      });
      this.quizzSrv.createReponse(reponseCJson).subscribe(() => {
      });
      this.quizzSrv.createReponse(reponseDJson).subscribe(() => {
        this.router.navigateByUrl('/modifQuizz')
      });
    });
  }

}
