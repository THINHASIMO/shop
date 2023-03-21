import {Component, OnInit} from '@angular/core';
import {iComponentBase} from '../../../base-module/functions/iServiceBase';
import {MessageService} from 'primeng/api';
import {Title} from '@angular/platform-browser';
import {ProductService} from '../../product.service';

@Component({
    selector: 'app-quan-ly-san-pham',
    templateUrl: './quan-ly-san-pham.component.html'
})
export class QuanLySanPhamComponent extends iComponentBase implements OnInit {

    products: any;

    constructor(public msg: MessageService, public title: Title, private product: ProductService) {
        super(msg, title);
    }

    ngOnInit(): void {
        this.product.getAllProduct('').subscribe(data => {
            this.products = data;
        });
    }

}
