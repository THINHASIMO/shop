import {NgModule} from '@angular/core';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {AutocompleteLibModule} from 'angular-ng-autocomplete';
import {PrimeNgModule} from '../primeng-module/primeng.module';
import {BaseModule} from '../base-module/base.module';
import {PaginatorModule} from 'primeng/paginator';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {MessageService} from 'primeng/api';
import {HomeComponent} from './components/home/home.component';

const routes: Routes = [
];

@NgModule({
    declarations: [
        HomeComponent
    ],
    imports: [
        FormsModule,
        AutocompleteLibModule,
        PrimeNgModule,
        RouterModule.forChild(routes),
        BaseModule,
        PaginatorModule
    ],
    exports: [HomeComponent],
    providers: [
        DialogService, DynamicDialogRef,
        MessageService,
        {provide: LocationStrategy, useClass: HashLocationStrategy}
    ],
})
export class SystemModule {
}
