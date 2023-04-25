import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { AnonymousGuardService } from './services/guard/anonymous-guard.service';
import { ProfilComponent } from './components/profil/profil.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { QuizzComponent } from './components/quizz/quizz.component';
import { StatistiquesComponent } from './components/statistiques/statistiques.component';
import { ThemeComponent } from './components/theme/theme.component';
import { UtilisateurGuardService } from './services/guard/utilisateur-guard.service';
import { AdminGuardService } from './services/guard/admin-guard.service';
import { PrepaQuizzComponent } from './components/quizz/prepa-quizz/prepa-quizz.component';
import { NonAdminGuardService } from './services/guard/non-admin-guard.service';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'connexion', component: ConnexionComponent,canActivate: [AnonymousGuardService]},
  {path: 'inscription', component: InscriptionComponent, canActivate: [AnonymousGuardService]},
  {path: 'profil', component: ProfilComponent, canActivate: [UtilisateurGuardService]},
  {path: '', redirectTo:'/home', pathMatch:'full'},
  {path: 'quizz', component: QuizzComponent, canActivate: [NonAdminGuardService]},
  {path: 'statistiques', component : StatistiquesComponent, canActivate: [UtilisateurGuardService]},
  {path: 'theme', component : ThemeComponent, canActivate: [AdminGuardService] },



];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
