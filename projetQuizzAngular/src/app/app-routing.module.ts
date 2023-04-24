import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AnonymousGuardService } from './services/guard/anonymous-guard.service';
import { ProfilComponent } from './components/profil/profil.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { QuizzComponent } from './components/quizz/quizz.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'connexion', component: ConnexionComponent,canActivate: [AnonymousGuardService]},
  {path: 'profil', component: ProfilComponent },
  {path: 'inscription', component: InscriptionComponent},
  {path: '', redirectTo:'/home', pathMatch:'full'},
  {path: 'quizz', component: QuizzComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
