export const Menu = {
    thuDen: '/thu-den',
    thuDi: '/thu-di',
    baoCao: '/bao-cao',
    danhMuc: '/danh-muc',
    conDau: '/con-dau',
    suDungConDau: '/dáuu-dung-con-dau'
};

export const childMenuThuDen = [
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDen + '/nhap-moi',
        label: 'Nhập mới'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDen + '/thu-moi',
        label: 'Thư mơi'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDen + '/thu-chua-nhan',
        label: 'Thư chưa nhận'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDen + '/thu-da-nhan',
        label: 'Thư đã nhận'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDen + '/tat-ca',
        label: 'Tất cả'
    }
];

export const childMenuThuDi = [
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/nhap-moi',
        label: 'Nhập mới'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/thu-dang-soan',
        label: 'Thư đang soạn'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/thu-tra-lai',
        label: 'Thư trả lại'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/thu-cho-xu-ly',
        label: 'Thư chờ xử lý'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/thu-da-gui',
        label: 'Thư đã gửi'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/ky-xac-nhan-don-vi-van-chuyen',
        label: 'Ký xác nhận của đơn vị vận chuyển'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.thuDi + '/tat-ca-thu-di',
        label: 'Tất cả'
    }
];

export const childMenuBaoCao = [
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.baoCao + '/bao-cao-so-thu-di',
        label: 'Báo cáo số thư đi'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.baoCao + '/bao-cao-so-thu-den',
        label: 'Báo cáo số thư đến'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.baoCao + '/bao-cao-theo-chi-phi',
        label: 'Báo cáo theo chi phí'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.baoCao + '/bao-cao-tong-hop-thu',
        label: 'Báo cáo tổng hợp thư'
    },
];

export const childMenuDanhMuc = [
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/don-vi-van-chuyen',
        label: 'Đơn vị vận chuyển'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/noi-nhan-ben-ngoai',
        label: 'Nơi nhận bên ngoài'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/do-mat',
        label: 'Độ mật'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/do-khan',
        label: 'Độ khẩn'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/loai-so-den',
        label: 'Loại sổ đến'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/loai-so-di',
        label: 'Loại sổ đi'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/mau-thu-den',
        label: 'Mẫu thư đến'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/mau-thu-di',
        label: 'Mẫu thư đi'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.danhMuc + '/import-thu-di',
        label: 'Import thư đi'
    }
];

export const childMenuConDau = [
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/quan-ly-yeu-cau',
        label: 'Quản lý yêu cầu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/danh-sach-con-dau',
        label: 'Danh sách con dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/thong-bao-nhan-dau',
        label: 'Thông báo nhận dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/danh-sach-thong-bao-nhan-con-dau',
        label: 'Danh sách thông báo nhận con dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/danh-sach-dang-ky-thong-tin-con-dau',
        label: 'Danh sách đăng ký thông tin nhận con dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/ban-giao-nhiem-vu-giam-sat-dau',
        label: 'Bàn giao nhiệm vụ giám sát dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/ban-giao-con-dau-giua-hoi-so-va-don-vi',
        label: 'Bàn giao con dấu giữa hội sở và đơn vị'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/ban-giao-con-dau-giua-noi-bo-don-vi',
        label: 'Bàn giao con dấu giữa nội bộ đơn vị'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/ban-giao-con-dau-hang-ngay',
        label: 'Bàn giao con dấu hàng ngày'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/giam-sat-giu-dong-dau',
        label: 'Bàn giao nhiệm vụ giám sát dấu, giữ và đóng dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/thu-hoi-con-dau',
        label: 'Xác nhận thu hồi con dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/tieu-huy-con-dau',
        label: 'Tiêu hủy con dấu'
    },
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.conDau + '/quan-ly-bo-tieu-chuan',
        label: 'Quản lý bộ tiêu chuẩn'
    }
];

export const childMenuSuDungConDau = [
    {
        icon: 'pi pi-angle-right',
        routerLink: Menu.suDungConDau + '/quan-ly-yeu-cau',
        label: 'Quản lý yêu cầu'
    },
];
