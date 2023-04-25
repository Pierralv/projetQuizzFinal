import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Compte } from 'src/app/model/compte';
import { Role } from 'src/app/model/role';

@Injectable({
  providedIn: 'root'
})
export class NonAdminGuardService {

  constructor() { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    if (sessionStorage.getItem('compte')) {
      let compte: Compte = JSON.parse(
        sessionStorage.getItem('compte')!
      ) as Compte;
      return compte.role == Role.ROLE_UTILISATEUR;
    }
    return true;
  }
}


