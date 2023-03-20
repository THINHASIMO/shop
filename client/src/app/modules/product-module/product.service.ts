import {Injectable} from '@angular/core';
import {ServiceBase} from '../base-module/service/api-service-base';
import * as API from '../../../app/modules/base-module/service/api-gateway';

@Injectable({
    providedIn: 'root'
})
export class ProductService extends ServiceBase {
    getAllProduct(sParam) {
        return this.get(API.ApiProduct.GET_ALL_PRODUCT);
    }
}
