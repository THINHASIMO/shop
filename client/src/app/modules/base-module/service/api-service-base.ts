import {
    HttpClient,
    HttpErrorResponse,
    HttpHeaders,
    HttpParams,
    HttpResponse,
} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {throwError, Observable} from 'rxjs';
import {catchError} from 'rxjs';
import {retry} from 'rxjs/operators';
import {FileSaverService} from 'ngx-filesaver';
import * as API from './api-gateway';
import {ServiceGateway} from './api-gateway';

@Injectable()
export class ServiceBase {
    constructor(
        public httpClient: HttpClient,
        private fileSaver: FileSaverService
    ) {
    }

    getOptionsRequest(ignoreLoading?: boolean, responseType?: string) {
        const options: any = {};
        if (ignoreLoading != undefined && ignoreLoading) {
            options.reportProgress = true;
        }
        if (responseType != undefined && responseType) {
            options.responseType = responseType;
        }
        return options;
    }

    getURLService(moduleApi: any) {
        try {
            switch (moduleApi) {
                case API.ApiProduct: {
                    return ServiceGateway.GET_WAY_SHOP + API.ApiRoot.PRODUCT;
                }
                default: {
                    return null;
                }
            }
        } catch (e) {
            console.log('API not found !');
            return null;
        }
    }

    public postData(
        service: any,
        api: any,
        inputData: any,
        ignoreLoading?: boolean,
        responseType?: string
    ): Observable<any> {
        try {
            // Get IP và URL
            const url = this.getURLService(service) + api;
            document.body.style.cursor = 'default';
            return this.httpClient
                .post(url, inputData, this.getOptionsRequest(ignoreLoading))
                .pipe(
                    retry(1),
                    catchError((error: HttpErrorResponse) => {
                        console.log('lỗi đây này', error);
                        return throwError(error);
                    })
                );
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
            return null;
        }
    }

    public getData(
        service: any,
        api: any,
        ignoreLoading?: boolean
    ): Observable<any> {
        try {
            const url = this.getURLService(service) + api;
            document.body.style.cursor = 'default';
            return this.httpClient.get(url).pipe(catchError(this.handleError));
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
        }
        return null as any;
    }

    public deletedData(
        service: any,
        api: any,
        ignoreLoading?: boolean
    ): Observable<any> {
        try {
            const url = this.getURLService(service) + api;
            document.body.style.cursor = 'default';
            return this.httpClient.delete(url).pipe(
                retry(1),
                // catchError(this.handleError)
                catchError((error: HttpErrorResponse) => {
                    console.log('lỗi đây này', error);
                    return throwError(error);
                })
            );
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
        }
        return null as any;
    }

    public putData(
        service: any,
        api: any,
        inputData: any,
        ignoreLoading?: boolean
    ): Observable<any> {
        try {
            // Get IP và URL
            const url = this.getURLService(service) + api;
            document.body.style.cursor = 'default';
            // @ts-ignore
            console.log(url);
            // @ts-ignore
            return this.httpClient
                .put(url, inputData, this.getOptionsRequest(ignoreLoading))
                .pipe(
                    retry(1),
                    // catchError(this.handleError)
                    catchError((error: HttpErrorResponse) => {
                        console.log('lỗi đây này', error);
                        return throwError(error);
                    })
                );
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
            return null as any;
        }
    }

    handleError(error: HttpErrorResponse) {
        let errorMessage = 'Unknown error!';
        if (error.error instanceof ErrorEvent) {
            return (errorMessage = `Error: ${error.error.message}`);
        } else if (error.error != ErrorEvent) {
            return null;
        } else {
            return (errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`);
        }
    }

    public get(url: string, params?: any): Observable<any> {
        try {
            document.body.style.cursor = 'default';
            return this.httpClient
                .get(url, {params})
                .pipe(catchError(this.handleError));
        } catch (error) {
            document.body.style.cursor = 'default';
        }
        return null;
    }

    download(url: string, params?: any): Observable<any> {
        try {
            document.body.style.cursor = 'default';
            return this.httpClient.get(url, {responseType: 'blob'});
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
            return null;
        }
    }

    public post(url: string, inputData: any, params?: any): Observable<any> {
        try {
            document.body.style.cursor = 'default';
            return this.httpClient
                .post(url, inputData, {params})
                .pipe(retry(1), catchError(this.handleError));
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
            return null;
        }
    }

    postImport(url: string, inputData: any, params?: any) {
        return this.httpClient.post(url, inputData, {params});
    }

    public delete(url: string, params?: any): Observable<any> {
        try {
            document.body.style.cursor = 'default';
            // @ts-ignore
            return this.httpClient
                .delete(url, {params})
                .pipe(retry(1), catchError(this.handleError));
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
        }
        return null;
    }

    public deleteBody(url: string, value?: any): Observable<any> {
        try {
            document.body.style.cursor = 'default';
            // @ts-ignore
            return this.httpClient.delete(url, {body: value});
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
        }
        return null;
    }

    public put(url: string, inputData: any, params?: any): Observable<any> {
        try {
            document.body.style.cursor = 'default';
            return this.httpClient
                .put(url, inputData, {params})
                .pipe(retry(1), catchError(this.handleError));
        } catch (error) {
            document.body.style.cursor = 'default';
            console.log(error);
            return null;
        }
    }

    saveFiles(
        nativeUrl: string,
        fileName: string,
        obj: any,
        options: { headers?: HttpHeaders; params?: HttpParams },
        baseUrl?: string,
        onErrorFunc?: (err: any) => void
    ) {
        console.log(obj);

        const url = this.getURLService(nativeUrl);
        this.httpClient
            .post(url == '' ? nativeUrl : url, obj, {
                headers: options.headers,
                params: options.params,
                observe: 'response',
                responseType: 'blob',
            })
            .subscribe(
                (l: HttpResponse<Blob>) => {
                    let filename = '';
                    console.log(l);
                    console.log(l.headers.get('content-disposition'));
                    const disposition = l.headers.get('Content-Disposition');
                    if (disposition && disposition.indexOf('attachment') !== -1) {
                        const filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                        const matches = filenameRegex.exec(disposition);
                        if (matches != null && matches[1]) {
                            filename = matches[1].replace(/['"]/g, '');
                        }
                    }
                    const blobData: Blob | null = l.body;
                    const contentType: string | null = l.headers.get('Content-Type');
                    if (blobData && contentType) {
                        this.fileSaver.save(blobData, fileName, contentType);
                    }
                },
                (err) => {
                    if (onErrorFunc) {
                        onErrorFunc(err);
                    }
                }
            );
    }
}
