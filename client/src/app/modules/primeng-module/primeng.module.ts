import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule} from '@angular/forms';
import {MessagesModule} from 'primeng/messages';
import {ToastModule} from 'primeng/toast';
import {iComponentBase} from '../base-module/functions/iServiceBase';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {ProgressBarModule} from 'primeng/progressbar';
import {BlockUIModule} from 'primeng/blockui';
import {MenubarModule} from 'primeng/menubar';
import {FieldsetModule} from 'primeng/fieldset';
import {CardModule} from 'primeng/card';
import {DropdownModule} from 'primeng/dropdown';
import {TableModule} from 'primeng/table';
import {RadioButtonModule} from 'primeng/radiobutton';
import {CalendarModule} from 'primeng/calendar';
import {CheckboxModule} from 'primeng/checkbox';
import {OverlayPanelModule} from 'primeng/overlaypanel';
import {PanelModule} from 'primeng/panel';
import {DialogModule} from 'primeng/dialog';
import {TreeSelectModule} from 'primeng/treeselect';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {InputNumberModule} from 'primeng/inputnumber';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {ConfirmPopupModule} from 'primeng/confirmpopup';
import {MultiSelectModule} from 'primeng/multiselect';
import {PanelMenuModule} from 'primeng/panelmenu';
import {StyleClassModule} from 'primeng/styleclass';
import {ImageModule} from 'primeng/image';
import {ChipsModule} from 'primeng/chips';
import {PaginatorModule} from 'primeng/paginator';
import {FileUploadModule} from 'primeng/fileupload';
import {HttpClientModule} from '@angular/common/http';
import {ChartModule} from 'primeng/chart';
import { BreadcrumbModule } from 'primeng/breadcrumb';
import {SelectButtonModule} from 'primeng/selectbutton';




@NgModule({
    declarations: [
        iComponentBase
    ],
    imports: [
        RadioButtonModule,
        CardModule,
        MenubarModule,
        BlockUIModule,
        ProgressBarModule,
        ProgressSpinnerModule,
        ToastModule,
        MessagesModule,
        CommonModule,
        ButtonModule,
        InputTextModule,
        FormsModule,
        FieldsetModule,
        DropdownModule,
        TableModule,
        RadioButtonModule,
        CalendarModule,
        CheckboxModule,
        OverlayPanelModule,
        PanelModule,
        DialogModule,
        TreeSelectModule,
        AutoCompleteModule,
        InputNumberModule,
        InputTextareaModule,
        ConfirmPopupModule,
        MultiSelectModule,
        PanelMenuModule,
        StyleClassModule,
        ImageModule,
        ChipsModule,
        PaginatorModule,
        FileUploadModule,
        HttpClientModule,
        ChartModule,
        BreadcrumbModule,
        SelectButtonModule
    ],
    exports: [
        RadioButtonModule,
        MenubarModule,
        BlockUIModule,
        ProgressBarModule,
        ProgressSpinnerModule,
        ToastModule,
        MessagesModule,
        CommonModule,
        ButtonModule,
        FormsModule,
        InputTextModule,
        iComponentBase,
        FieldsetModule,
        CardModule,
        DropdownModule,
        TableModule,
        RadioButtonModule,
        CalendarModule,
        CheckboxModule,
        OverlayPanelModule,
        PanelModule,
        DialogModule,
        TreeSelectModule,
        AutoCompleteModule,
        InputNumberModule,
        InputTextareaModule,
        ConfirmPopupModule,
        MultiSelectModule,
        PanelMenuModule,
        StyleClassModule,
        ImageModule,
        ChipsModule,
        PaginatorModule,
        FileUploadModule,
        HttpClientModule,
        ChartModule,
        BreadcrumbModule,
        SelectButtonModule
    ],

})
export class PrimeNgModule {
}
