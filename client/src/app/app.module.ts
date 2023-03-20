import {APP_INITIALIZER, Injector, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {StepsModule} from 'primeng/steps';
import {LoginComponent} from './modules/system-module/components/login-component/login.component';
import {appRoutingModule} from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CommonModule, HashLocationStrategy, LocationStrategy} from '@angular/common';
import {TopMenuComponent} from './app-menu/top-menu/top-menu.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {authInterceptorProviders} from './modules/base-module/service/MyHttpInterceptor';
import {PrimeNgModule} from './modules/primeng-module/primeng.module';
import {BaseModule} from './modules/base-module/base.module';
import {SideNav} from './app-demo/side-nav/side-nav';
import {TaoMenuDocComponent} from './app-demo/tao-menu-doc/tao-menu-doc.component';
import {LeftComponent} from './app-menu/left-menu/left-menu.component';
import {AppMenuComponent} from './app-menu/app-menu.component';
import {BodyComponent} from './app-menu/left-menu/body/body.component';
import {LoaderService} from './modules/base-module/service/loader.service';
import {NsLoaderComponent} from './modules/base-module/components/ns-loader/ns-loader.component';
import {LoaderInterceptor} from './modules/base-module/service/loader.interceptor';
import {DialogService} from 'primeng/dynamicdialog';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {initializeKeycloak} from './init/keycloak-init.factory';
import {KeycloakBearerInterceptor} from './init/KeycloakBearerInterceptor';
import {SystemModule} from './modules/system-module/system-module';
import {ProductModule} from './modules/product-module/product.module';

export let AppInject: Injector;

@NgModule({
    imports: [
        PrimeNgModule,
        BaseModule,
        FormsModule,
        ReactiveFormsModule,
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        appRoutingModule,
        StepsModule,
        BrowserModule,
        HttpClientModule,
        KeycloakAngularModule,
        SystemModule,
        ProductModule

    ],
    declarations: [
        AppComponent,
        LoginComponent,
        TopMenuComponent,
        SideNav, // demo widget menu
        TaoMenuDocComponent,  // demo widget menu
        LeftComponent, // demo widget menu right
        AppMenuComponent, //  demo widget menu right
        BodyComponent,
        NsLoaderComponent,
    ],
    exports: [
        PrimeNgModule,
        LoginComponent,
        BaseModule,
        SystemModule
    ],
    providers: [
        authInterceptorProviders,
        {provide: LocationStrategy, useClass: HashLocationStrategy},
        {provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true},
        {provide: HTTP_INTERCEPTORS, useClass: KeycloakBearerInterceptor, multi: true},
        LoaderService,
        DialogService,
        {
            provide: APP_INITIALIZER,
            useFactory: initializeKeycloak,
            multi: true,
            deps: [KeycloakService],
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
    constructor(private injector: Injector) {
        AppInject = this.injector;
    }
}
