import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { LienComponent } from './components/lien/lien.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { ProfilComponent } from './components/profil/profil.component';
import { ThemeComponent } from './components/theme/theme.component';
import { StatistiquesComponent } from './components/statistiques/statistiques.component';
import { QuizzComponent } from './components/quizz/quizz.component';
import { ModifierProfilComponent } from './components/profil/modifier-profil/modifier-profil.component';
import { ChoixAvatarComponent } from './components/choix-avatar/choix-avatar.component';
import { PrepaQuizzComponent } from './components/quizz/prepa-quizz/prepa-quizz.component';
import { QuestionComponent } from './components/quizz/question/question.component';
import { ModifQuizzComponent } from './components/modif-quizz/modif-quizz.component';
import { EditModifQuizzComponent } from './components/modif-quizz/edit-modif-quizz/edit-modif-quizz.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    LienComponent,
    NavBarComponent,
    HomeComponent,
    InscriptionComponent,
    ProfilComponent,
    ThemeComponent,
    StatistiquesComponent,
    QuizzComponent,
    ModifierProfilComponent,
    ChoixAvatarComponent,
    PrepaQuizzComponent,
    QuestionComponent,
    ModifQuizzComponent,
    EditModifQuizzComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
