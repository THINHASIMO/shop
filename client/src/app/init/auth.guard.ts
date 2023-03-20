import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { KeycloakAuthGuard, KeycloakService } from 'keycloak-angular';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard {

  constructor(
    protected readonly router: Router,
    protected readonly keycloak: KeycloakService
  ) {
    super(router, keycloak);
  }

  async isAccessAllowed(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Promise<boolean | UrlTree> {

    if (!this.authenticated) {
      console.log('heeeeeeeeeeeeeeeee', window.location, state.url);
      await this.keycloak.login({
        // redirectUri: window.location.origin + window.location.pathname
        redirectUri: window.location.origin + state.url,

      });
      this.authenticated = true;
    }
    // redirectUri: window.location.origin + state.url,
    return this.authenticated;
  }
}
