import {Component} from '@angular/core';
import { MessageService} from 'primeng/api';
import {Title} from '@angular/platform-browser';
import {iFunction} from './iFunction';
import {SharedApi} from '../service/api.shared.services';
import {AppInject} from 'src/app/app.module';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {CookieService} from '../../system-module/functions/store/cookie.service';
import {DIALOG_SIZES, ICONS} from '../../../../environments/environment';

export const enum cType {
    question,
    trash,
    edit
}

export const enum mType {
    success,
    info,
    warn,
    error
}

export const VN_LOCAL = {
    firstDayOfWeek: 0,
    dayNames: ['Chủ nhật', 'Thứ hai', 'Thứ ba', 'Thứ tư', 'Thứ năm', 'Thứ sáu', 'Thứ bảy'],
    dayNamesShort: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
    dayNamesMin: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
    monthNames: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
    monthNamesShort: ['TH1', 'TH2', 'TH3', 'TH4', 'TH5', 'TH6', 'TH7', 'TH8', 'TH9', 'TH10', 'TH11', 'TH12'],
    today: 'Hôm nay',
    clear: 'Xóa'
};

@Component({
    selector: 'app-i-com',
    template: `<p></p>`,
})
// tslint:disable-next-line:class-name component-class-suffix
export class iComponentBase extends iFunction {
    baseShareApi: SharedApi;
    currentUser: any;
    currentStaff: any;
    ref: DynamicDialogRef;
    dialogService: DialogService;
    cookieService: CookieService;

    constructor(public messageService: MessageService,
                public titleService?: Title) {
        super();
        this.init();
    }

    init() {
        this.baseShareApi = AppInject.get(SharedApi);
        this.cookieService = AppInject.get(CookieService);
    }

    setTitle(isParentMenu = true) {
        this.titleService.setTitle('MBer');
    }

    showMessage(iType: mType, strheader: any, strmessage: any, key?: string) {
        if (iType == 0) {
            if (key != undefined) {
                this.messageService.add({key, severity: 'success', summary: strheader, detail: strmessage});
            } else {
                this.messageService.add({severity: 'success', summary: strheader, detail: strmessage});
            }

        }
        if (iType == 1) {
            if (key != undefined) {
                this.messageService.add({key, severity: 'info', summary: strheader, detail: strmessage});
            } else {
                this.messageService.add({severity: 'info', summary: strheader, detail: strmessage});
            }
        }

        if (iType == 2) {
            if (key != undefined) {
                this.messageService.add({key, severity: 'warn', summary: strheader, detail: strmessage});
            } else {
                this.messageService.add({severity: 'warn', summary: strheader, detail: strmessage});
            }
        }

        if (iType == 3) {
            if (key != undefined) {
                this.messageService.add({key, severity: 'error', summary: strheader, detail: strmessage});
            } else {
                this.messageService.add({severity: 'error', summary: strheader, detail: strmessage});
            }
        }
    }

    get icons() {
        return ICONS;
    }

    get dialogSize() {
        return DIALOG_SIZES;
    }
}
