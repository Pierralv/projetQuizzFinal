import { Component } from '@angular/core';
import { Compte } from 'src/app/model/compte';
import { ConnexionService } from 'src/app/services/connexion.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  get showConnexion() {
    if (sessionStorage.getItem('compte')) {
      return false;
    }
    return true;
  }
}
