import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {KeycloakService} from 'keycloak-angular';


@Injectable({
    providedIn: 'root'
})
export class CookieService {
    user: any;

    constructor(public router: Router, private keycloakService: KeycloakService) {
        this.user = window.localStorage.getItem('userName');
    }

    getUserFromStorage() {
        // return this.getCurrentUser().username;
    }

    getToken() {
        // return this.getCurrentUser().accessToken;
    }

    getCurrentUser() {
        // let currentUser = JSON.parse(this.getCookie('currentUser'));
        // if (!currentUser) {
        //     const kc = this.keycloakService.getKeycloakInstance();
        //     currentUser = {
        //         accessToken: kc.token,
        //         roles: this.keycloakService.getUserRoles(false),
        //         username: kc.tokenParsed['preferred_username'],
        //         refreshToken: kc.refreshToken
        //     };
        //     this.setCookie('currentUser',  JSON.stringify(currentUser));
        // }
        //
        // return currentUser;
    }

    setCookie(cName, data) {
        document.cookie = cName + '= ' + data + '; path=/;';
    }

    logout(): void {
        this.clearCookies();
        window.localStorage.clear();
        this.keycloakService.logout(`${window.location.origin}`).then(() => this.keycloakService.clearToken());
    }

    getCookie(cname) {
        const name = cname + '=';
        const decodedCookie = decodeURIComponent(document.cookie);
        const ca = decodedCookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return null;
    }

    clearCookies() {
        const cookies = document.cookie.split(';');
        for (let i = 0; i < cookies.length; i++) {
            const cookie = cookies[i];
            const eqPos = cookie.indexOf('=');
            const name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
            document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT';
        }
    }
}
