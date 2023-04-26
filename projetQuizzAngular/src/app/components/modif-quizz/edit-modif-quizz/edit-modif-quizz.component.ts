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

  themes: Theme[] = [];
  selectedTheme: Theme = new Theme();
  question: Question = new Question();

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

  submit() {
    console.log('submit !');

    let questionJson = {
      enonceQuestion: this.form.get('enonceQuestion').value,
      theme: this.form.get('theme').value,
      reponses: [
        {
          enonceReponse: this.form.get('reponseA').value,
          bonneReponse: false,
        },
        {
          enonceReponse: this.form.get('reponseB').value,
          bonneReponse: false,
        },
        {
          enonceReponse: this.form.get('reponseC').value,
          bonneReponse: true,
        },
        {
          enonceReponse: this.form.get('reponseD').value,
          bonneReponse: false,
        },
      ],
    };
    console.log(questionJson);
    this.quizzSrv.create(questionJson).subscribe(()=>{
      this.router.navigateByUrl('/modifQuizz')
    })
    
  }
}
