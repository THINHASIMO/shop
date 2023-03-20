import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent
} from '@angular/common/http';

import { Observable, combineLatest } from 'rxjs';
import { mergeMap } from 'rxjs/operators';
import {ExcludedUrlRegex} from 'keycloak-angular/lib/core/interfaces/keycloak-options';
import {KeycloakService} from 'keycloak-angular';


/**
 * This interceptor includes the bearer by default in all HttpClient requests.
 *
 * If you need to exclude some URLs from adding the bearer, please, take a look
 * at the {@link KeycloakOptions} bearerExcludedUrls property.
 */
@Injectable()
export class KeycloakBearerInterceptor implements HttpInterceptor {
  constructor(private keycloak: KeycloakService) {}

  /**
   * Calls to update the keycloak token if the request should update the token.
   *
   * @param req http request from @angular http module.
   * @returns
   * A promise boolean for the token update or noop result.
   */
  private async conditionallyUpdateToken(
    req: HttpRequest<unknown>
  ): Promise<boolean> {
    if (this.keycloak.shouldUpdateToken(req)) {
      return await this.keycloak.updateToken();
    }

    return true;
  }

  /**
   * @deprecated
   * Checks if the url is excluded from having the Bearer Authorization
   * header added.
   *
   * @param req http request from @angular http module.
   * @param excludedUrlRegex contains the url pattern and the http methods,
   * excluded from adding the bearer at the Http Request.
   */
  private isUrlExcluded(
    { method, url }: HttpRequest<unknown>,
    { urlPattern, httpMethods }: ExcludedUrlRegex
  ): boolean {
    const httpTest = !httpMethods ||
      httpMethods?.length === 0 ||
      httpMethods.join().indexOf(method.toUpperCase()) > -1;

    const urlTest = urlPattern.test(url);

    return httpTest && urlTest;
  }


  public intercept(
    req: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    const { enableBearerInterceptor, excludedUrls } = this.keycloak;
    if (!enableBearerInterceptor) {
      return next.handle(req);
    }

    const shallPass: boolean =
      !this.keycloak.shouldAddToken(req) ||
      excludedUrls.findIndex((item) => this.isUrlExcluded(req, item)) > -1;
    if (shallPass) {
      return next.handle(req);
    }

    return combineLatest([
      this.conditionallyUpdateToken(req),
      this.keycloak.isLoggedIn()
    ]).pipe(
      mergeMap(([_, isLoggedIn]) =>
        isLoggedIn
          ? this.handleRequestWithTokenHeader(req, next)
          : next.handle(req)
      )
    );
  }


  private handleRequestWithTokenHeader(
    req: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {

    req.headers.set('TENANT_ID', this.keycloak.getKeycloakInstance().realm??'');
    return this.keycloak.addTokenToHeader(req.headers).pipe(
      mergeMap((headersWithBearer) => {
        // console.log('hereeeeeeeeeeeee', headersWithBearer);
        const kcReq = req.clone({ headers: headersWithBearer });
        return next.handle(kcReq);
      })
    );
  }
}
