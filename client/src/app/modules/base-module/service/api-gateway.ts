import {environment, keycloakConfig} from '../../../../environments/environment';

export class ServiceGateway {
    public static GET_WAY_SHOP = environment.shop;
    public static GET_WAY_KEYCLOAK = keycloakConfig.url;
}

export class ApiRoot {
    // Các phân hệ chính
    public static KEYCLOAK = 'auth/';
    public static PRODUCT = ServiceGateway.GET_WAY_SHOP + 'product/';
}

export class ApiProduct {
    public static rootUrl = ApiRoot.PRODUCT;
    public static GET_ALL_PRODUCT = ApiProduct.rootUrl + 'get-all';
}

export class ApiKeycloak {
    public static rootUrl = ApiRoot.KEYCLOAK;
    public static KEYCLOAK_USERS = this.rootUrl + 'users';
    public static KEYCLOAK_UPDATE_ROLES = this.rootUrl + 'roles-by-id/';
    public static KEYCLOAK_GET_ROLES = this.rootUrl + 'clients/' + keycloakConfig.clientUUID + '/roles';
    public static KEYCLOAK_GET_RESOURCE = this.rootUrl + 'clients/' + keycloakConfig.clientUUID + '/authz/resource-server/resource';
    public static KEYCLOAK_GET_ROLE_SCOPE = this.rootUrl + 'clients/' + keycloakConfig.clientUUID + '/authz/resource-server/scope';
}
