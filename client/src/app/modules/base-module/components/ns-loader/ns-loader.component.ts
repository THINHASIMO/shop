import {Component, Input} from '@angular/core';
import {LoaderService} from '../../service/loader.service';


@Component({
    selector: 'app-ns-loader',
    template: `
        <div class="ns-loader progress-loader" *ngIf="loaderService.isLoading | async">
            <div class="loading">
                <p-progressSpinner></p-progressSpinner>
                <!--                <img *ngIf="imgSrc ? true : false" [src]="imgSrc"/>-->
            </div>
        </div>
    `,
    styleUrls: ['./ns-loader.component.scss'],
})
export class NsLoaderComponent {
    constructor(public loaderService: LoaderService) {
    }
}
