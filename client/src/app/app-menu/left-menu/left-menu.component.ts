import {Component, OnInit} from '@angular/core';
import {iComponentBase} from '../../modules/base-module/functions/iServiceBase';
import {CookieService} from '../../modules/system-module/functions/store/cookie.service';
import {SharedApi} from '../../modules/base-module/service/api.shared.services';
import {Title} from '@angular/platform-browser';
import {MessageService} from 'primeng/api';
import {MenuItem} from 'primeng/api';
import {
    childMenuThuDen,
    childMenuThuDi,
    childMenuBaoCao,
    childMenuDanhMuc,
    childMenuConDau
} from '../auth-menu/menu.contants';
import {MenuService} from '../app-menu.service';


@Component({
    selector: 'app-left-menu',
    templateUrl: './left-menu.component.html',
    styleUrls: ['./left-menu.component.scss']
})
export class LeftComponent extends iComponentBase implements OnInit {
    user: any;
    items: MenuItem[];
    isClose = false;


    constructor(private taoMenuDocService: MenuService,
                private tokenStorageService: CookieService,
                public title: Title,
                public msg: MessageService) {
        super(msg, title);
        this.user = this.tokenStorageService.getUserFromStorage(); // get thông tin người dùng đăng nhập
    }

    ngOnInit(): void {
        this.items = [
            {
                label: 'Thư đên',
                icon: 'pi pi-fw pi-book',
                items: [
                    ...childMenuThuDen
                ]
            },
            {
                label: 'Thư đi',
                icon: 'pi pi-fw pi-book',
                items: [
                    ...childMenuThuDi
                ]
            },
            {
                label: 'Danh mục',
                icon: 'pi pi-fw pi-book',
                items: [
                    ...childMenuDanhMuc
                ]
            },
            {
                label: 'Quản lý con dấu',
                icon: 'pi pi-fw pi-book',
                items: [
                    ...childMenuConDau
                ]
            },
            {
                label: 'Báo cáo',
                icon: 'pi pi-fw pi-book',
                items: [
                    ...childMenuBaoCao
                ]
            },
        ];
    }

    clickCollapse(click) {
        this.isClose = !this.isClose;
        console.log('click menu isClick', this.isClose);
    }
}
