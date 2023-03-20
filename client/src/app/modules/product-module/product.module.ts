import {NgModule} from '@angular/core';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';
import {QuanLySanPhamComponent} from './components/quan-ly-san-pham/quan-ly-san-pham.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {PrimeNgModule} from '../primeng-module/primeng.module';
import {BaseModule} from '../base-module/base.module';
import {MessageService} from 'primeng/api';

const routes: Routes = [
    {path: 'quan-ly-san-pham', component: QuanLySanPhamComponent},
];

@NgModule({
    declarations: [
        QuanLySanPhamComponent
    ],
    imports: [
        FormsModule,
        PrimeNgModule,
        RouterModule.forChild(routes),
        BaseModule,
    ],
    providers: [
        MessageService,
        {provide: LocationStrategy, useClass: HashLocationStrategy}
    ],
    bootstrap: []
})

export class ProductModule {
}
