import { QuizzService } from 'src/app/services/quizz.service';
import { Component, OnInit } from '@angular/core';
import { Theme } from 'src/app/model/theme';
import { Question } from 'src/app/model/question';

@Component({
  selector: 'app-modif-quizz',
  templateUrl: './modif-quizz.component.html',
  styleUrls: ['./modif-quizz.component.css']
})
export class ModifQuizzComponent implements OnInit {
constructor(private quizzSrv: QuizzService){}

themes:Theme[] = [];
questionsByTheme: Question[] = [];
selectedTheme: Theme = new Theme();

  ngOnInit(): void {
    this.loadThemes();
  }

  loadThemes(){
    this.quizzSrv.getAllThemes().subscribe((themes:Theme[]) => {
      this.themes = themes;
    })
  }

  selected(){
    console.log(this.selectedTheme.id);
    this.quizzSrv.getQuestionByTheme((this.selectedTheme.id)).subscribe((theme:Theme) => {
      this.questionsByTheme= theme.questions;
    })
  }

}
