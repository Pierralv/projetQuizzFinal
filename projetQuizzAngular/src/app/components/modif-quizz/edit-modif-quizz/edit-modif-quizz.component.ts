import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Question } from 'src/app/model/question';
import { Reponse } from 'src/app/model/reponse';
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
  bonneReponse:boolean = false;
  themes: Theme[] = [];
  selectedTheme: Theme = new Theme();
  resultat:boolean;

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

  changeReponse(ev : Event) {

    let result = (ev.target as HTMLInputElement).value
    console.log(this.bonneReponse);
    if(result=='true'){
      this.bonneReponse = false
    } else {
      this.bonneReponse = true
    }
    console.log(this.bonneReponse)
  }

  submit() {
    let questionJson = {
      enonceQuestion: this.form.get('enonceQuestion').value,
      theme: this.form.get('theme').value,
    };
    console.log(questionJson);
    this.quizzSrv.createQuestion(questionJson).subscribe((resp) => {
      console.log(resp);

      let reponseAJson = {
        enonceReponse: this.form.get('reponseA').value,
        bonneReponse: false,
        question: resp
      };
      let reponseBJson = {
        enonceReponse: this.form.get('reponseB').value,
        bonneReponse: false,
        question: resp
      };
      let reponseCJson = {
        enonceReponse: this.form.get('reponseC').value,
        bonneReponse: true,
        question: resp
      };
      let reponseDJson = {
        enonceReponse: this.form.get('reponseD').value,
        bonneReponse: false,
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
