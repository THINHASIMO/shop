export const environment = {
    production: false,
    shop: 'http://localhost:9191/', // api con dấu
};

export const keycloakConfig = {
    url: 'http://123.24.142.93:8180/auth',
    realm: 'internal',
    clientId: 'mberapp',
    clientUUID: '6395bce8-db90-47d4-9ad6-94ef1fd34a78',
};

export const ICONS = {
    search: 'pi pi-search',        // tìm kiếm
    add: 'pi pi-plus',             // mở màn tạo mới
    close: 'pi pi-times',          // đóng
    save: 'pi pi-save',            // xác nhận thêm mới
    yes: 'pi pi-check',            // đồng ý
    selected: 'pi pi-check-circle', // chọn dữ liệu
    clear: 'pi pi-replay',         // làm mới
    comeBack: 'pi pi-sort-alt',    // bàn giao lại
    detail: 'pi pi-book',          // xem chi tiết
    download: 'pi pi-download',    // tải file
    approve: 'pi pi-check-circle', // phê duyệt
    refuse: 'pi pi-times-circle',  // từ chối
    send: 'pi pi-telegram'   ,     // Gửi
    image: 'pi pi-image'    ,      // ảnh
    delete: 'pi pi-trash'    ,     // xóa
};
export const DIALOG_SIZES = {
    BIG: {width: '85vw', height: '90vh'},
    BIG_H_90: {width: '85vw', height: '85vh'},
    BIG_MAX_H_90: {width: '85vw', 'max-height': '90vh'},
    MEDIUM: {width: '85vw', height: '60vh'},
    MEDIUM_H_85: {width: '85vw', height: '85vh'},
    MEDIUM_W_65_H_65: {width: '65vw', height: '65vh'},
    MEDIUM_W_65_H_90: {width: '65vw', 'max-height': '90vh'},
    MEDIUM_MAX_H_85: {width: '85vw', 'max-height': '85vh'},
    SMALL: {width: '45vw', height: '30vh'},
    SMALL_MAX_H_85: {width: '45vw', 'max-height': '85vh'},
};
