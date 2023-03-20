import {Routes, RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {AuthGuard} from './init/auth.guard';

const routes: Routes = [
    {
        // path: '', canActivate: [AuthGuard],
        path: '',
        // redirectTo: '/',
        // pathMatch: 'full'
        component: AppComponent,
    },
    // {
    //   path: 'login',
    //   component: LoginComponent,
    // },

    {
        path: 'quan-tri-he-thong',
        loadChildren: () => import('./modules/system-module/system-module').then(m => m.SystemModule),
    },
    {
        path: 'san-pham',
        loadChildren: () => import('./modules/product-module/product.module').then(m => m.ProductModule),
    }
];


export const appRoutingModule = RouterModule.forRoot(routes);
