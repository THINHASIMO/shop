import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-menu',
    templateUrl: './app-menu.component.html',
    styleUrls: ['./app-menu.component.scss']
})
export class AppMenuComponent implements OnInit {
    changedMenu = false;
    constructor() {
        this.changedMenu = false;
    }

    ngOnInit(): void {
    }

    switchMenu() {
        this.changedMenu = !this.changedMenu;
    }
}
