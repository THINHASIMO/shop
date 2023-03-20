import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {CookieService} from './modules/system-module/functions/store/cookie.service';
import {MessageService, PrimeNGConfig} from 'primeng/api';
import {SharedApi} from './modules/base-module/service/api.shared.services';
import {Title} from '@angular/platform-browser';
import {iComponentBase, VN_LOCAL} from './modules/base-module/functions/iServiceBase';


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
})
export class AppComponent extends iComponentBase implements OnInit {
    constructor(
        private tokenStorageService: CookieService,
        private primengConfig: PrimeNGConfig,
        public router: Router,
        private sharedApi: SharedApi,
        private msg: MessageService,
        private title: Title,
        public route: ActivatedRoute
    ) {
        super(msg, title);
        this.primengConfig.setTranslation(VN_LOCAL);
    }

    ngOnInit(): void {
        this.router.events.subscribe((event: any) => {
            if (event instanceof NavigationEnd) {
                setTimeout(() => {
                    this.router.navigate([this.router.url]);
                }, 100);
            }
        });
    }

    freshApp() {
        window.location.reload();
    }
}
