import { Component, OnInit } from '@angular/core';
import {iComponentBase} from '../../modules/base-module/functions/iServiceBase';
import {CookieService} from '../../modules/system-module/functions/store/cookie.service';
import {SharedApi} from '../../modules/base-module/service/api.shared.services';
import {Title} from '@angular/platform-browser';
import {MessageService} from 'primeng/api';
import {TaoMenuDocService} from './tao-menu-doc.service';
import {MenuItem} from 'primeng/api';


@Component({
  selector: 'app-tao-menu-doc',
  templateUrl: './tao-menu-doc.component.html',
  styleUrls: ['./tao-menu-doc.component.scss']
})
export class TaoMenuDocComponent extends iComponentBase implements OnInit {
  user: any;
  items: MenuItem[];
  constructor(private taoMenuDocService: TaoMenuDocService,
              private tokenStorageService: CookieService,
              private shareApi: SharedApi,
              public title: Title,
              public msg: MessageService) {
    super(msg, title);
    this.user = this.tokenStorageService.getUserFromStorage(); // get thông tin người dùng đăng nhập
  }

  ngOnInit(): void {
    this.items = [
      {
        label: 'Thư đến',
        icon: 'pi pi-fw pi-file',
        items: [
          {
            label: 'Nhập mới ',
            icon: 'pi pi-fw pi-plus',
          },
          {
            label: 'Thư mới',
            icon: 'pi pi-fw pi-envelope'
          },
          {
            label: 'Thư chưa nhận',
            icon: 'pi pi-fw pi-external-link'
          },
          {
            label: 'Thư đã nhận',
            icon: 'pi pi-fw pi-external-link'
          },
          {
            label: 'Tất cả thư',
            icon: 'pi pi-fw pi-external-link'
          },
        ]
      },
      {
        label: 'Thư đi',
        icon: 'pi pi-fw pi-pencil',
        items: [
          {
            label: 'Nhập mới',
            icon: 'pi pi-fw pi-align-left'
          },
          {
            label: 'Thưu đang soạn ',
            icon: 'pi pi-fw pi-align-right'
          },
          {
            label: 'Thư trả lại',
            icon: 'pi pi-fw pi-align-center'
          },
          {
            label: 'Thư chờ sủ lý',
            icon: 'pi pi-fw pi-align-justify'
          },
          {
            label: 'Thư đã gửi',
            icon: 'pi pi-fw pi-align-justify'
          },
          {
            label: 'Impost thư đi',
            icon: 'pi pi-fw pi-align-justify'
          },
          {
            label: 'Tất cả',
            icon: 'pi pi-fw pi-align-justify'
          },
        ]
      },
      {
        label: 'Danh mục',
        icon: 'pi pi-fw pi-user',
        items: [
          {
            label: 'Nơi nhận bên ngoài',
            icon: 'pi pi-fw pi-user-plus',

          },
          {
            label: 'Độ mật',
            icon: 'pi pi-fw pi-user-minus',
          },
          {
            label: 'Độ khẩn',
            icon: 'pi pi-fw pi-users',
          },
          {
            label: 'Sổ thư đến ',
            icon: 'pi pi-fw pi-users',
          },
          {
            label: 'Sổ thư đi',
            icon: 'pi pi-fw pi-users',
          },
          {
            label: 'Mẫu thư đến',
            icon: 'pi pi-fw pi-users',
          },
          {
            label: 'Mẫu thư đi',
            icon: 'pi pi-fw pi-users',
          },
        ]
      },
      {
        label: 'Quản lý con dấu',
        icon: 'pi pi-fw pi-calendar',
        items: [
          {
            label: 'Quản lý danh sách con dấu',
            icon: 'pi pi-fw pi-pencil',
          },
          {
            label: 'Quản lý yêu cầu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'Danh sách con dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'Thông báo nhận dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'Danh sách thông báo nhận con dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'Danh sách đăng ký thông tin nhận con dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'bàn giao nhiệm vụ giám sát dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'bàn giao nhiệm vụ giám sát dấu, giữu và đóng giấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'xác nhận thu hồi con dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
          {
            label: 'Tiêu hủy con dấu',
            icon: 'pi pi-fw pi-calendar-times',
          },
        ]
      },
      {
        label: 'Báo cáo',
        icon: 'pi pi-book',
        items: [
          {
            label: 'Báo cáo sổ thư đi',
            icon: 'pi pi-fw pi-pencil',
          },
          {
            label: 'Báo cáo sổ thư đến',
            icon: 'pi pi-save',
          },
          {
            label: 'Báo cáo theo chi phí',
            icon: 'pi pi-save',
          },
          {
            label: 'Báo cáo tổng hợp thu',
            icon: 'pi pi-save',
          },
        ]
      }
    ];
  }

}
