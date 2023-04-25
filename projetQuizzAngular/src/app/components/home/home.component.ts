import { Component } from '@angular/core';
import { Compte } from 'src/app/model/compte';
import { ConnexionService } from 'src/app/services/connexion.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  get welcome() {
    let _welcome = 'bonjour ';
    if (sessionStorage.getItem('compte')) {
      let compte = JSON.parse(sessionStorage.getItem('compte')!) as Compte;
      _welcome = _welcome + compte.pseudo;
    }
    return _welcome;
  }

}
