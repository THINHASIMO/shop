import {Component, HostListener, Input, OnInit} from '@angular/core';
import {CookieService} from '../../modules/system-module/functions/store/cookie.service';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {AuthMenu} from '../auth-menu/auth-menu.component';


@Component({
    selector: 'app-top-menu',
    templateUrl: './top-menu.component.html',
    styleUrls: ['./top-menu.component.scss']
})
export class TopMenuComponent implements OnInit {
    menu: any;
    isHome = false;
    info: any;
    user: any;
    status = false;
    public getScreenWidth: any;
    public getScreenHeight: any;
    @Input() isLogin = false;

    constructor(private tokenStorageService: CookieService,
                public router: Router, public route: ActivatedRoute) {
        this.menu = [
            {
                name: 'Quản trị hệ thống',
                data: [{
                    icon: 'pi pi-angle-right',
                    routerLink: '/quan-tri-he-thong/quan-ly-tai-khoan',
                    label: 'Quản lý tài khoản'
                },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-quyen',
                        label: 'Quản lý quyền'
                    },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-quyen-thao-tac',
                        label: 'Quản lý quyền thao tác'
                    },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-chuc-nang',
                        label: 'Quản lý chức năng'
                    }]
            },
            {
                name: 'Khách hàng',
                data: [{
                    icon: 'pi pi-angle-right',
                    routerLink: '/quan-tri-he-thong/quan-ly-tai-khoan',
                    label: 'Quản lý tài khoản'
                },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-quyen',
                        label: 'Quản lý quyền'
                    },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-quyen-thao-tac',
                        label: 'Quản lý quyền thao tác'
                    },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-chuc-nang',
                        label: 'Quản lý chức năng'
                    }]
            },
            {
                name: 'Sản phẩm',
                data: [{
                    icon: 'pi pi-angle-right',
                    routerLink: '/san-pham/quan-ly-san-pham',
                    label: 'Quản lý sản phẩm'
                },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-quyen',
                        label: 'Sản phẩm lỗi'
                    },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-quyen-thao-tac',
                        label: 'Sản phẩm trả lại kho hàng'
                    },
                    {
                        icon: 'pi pi-angle-right',
                        routerLink: '/quan-tri-he-thong/quan-ly-chuc-nang',
                        label: 'Sản phẩm đã bán đi'
                    }]
            }
        ];
    }

    checkUrl() {
        this.router.events.subscribe((event: any) => {
            if (event instanceof NavigationEnd) {
                // console.log('url', this.router.url);
                if (this.router.url === '/') {
                    this.isHome = true;
                } else {
                    this.isHome = false;
                }
            }
        });
    }

    ngOnInit(): void {
        this.checkUrl();
        this.getScreenWidth = window.innerWidth;
        this.getScreenHeight = window.innerHeight;
        this.user = this.tokenStorageService.getUserFromStorage();
        if (this.user) {
            this.isLogin = true;
        } else {
            this.isLogin = false;
        }
    }

    clickEvent() {
        setTimeout(() => {
            this.status = !this.status;
            return;
        }, 10);
    }

    @HostListener('window:resize', ['$event'])
    onWindowResize() {
        this.getScreenWidth = window.innerWidth;
        this.getScreenHeight = window.innerHeight;
    }

    logout() {
        this.isLogin = false;
        this.tokenStorageService.logout();
    }
}
