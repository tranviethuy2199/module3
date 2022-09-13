CREATE database furama;

CREATE TABLE vi_tri (
ma_vi_tri int  PRIMARY KEY,
ten_vi_tri varchar(45));

CREATE TABLE trinh_do(
ma_trinh_do int  PRIMARY KEY,
ten_trinh_do varchar(45));

CREATE TABLE bo_phan(
ma_bo_phan int  PRIMARY KEY,
ten_bo_phan varchar(45));

CREATE TABLE nhan_vien(
ma_nhan_vien int  PRIMARY KEY,
ho_ten varchar(45),
ngay_sinh DATE,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
FOREIGN KEY (ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan));


CREATE TABLE loai_khach(
ma_loai_khach int  PRIMARY KEY,
ten_loai_khach varchar(45));

CREATE TABLE khach_hang(
ma_khach_hang int  PRIMARY KEY,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach(ma_loai_khach));


CREATE TABLE loai_dich_vu(
ma_loai_dich_vu int  PRIMARY KEY,
ten_loai_dich_vu varchar(45));

CREATE TABLE kieu_thue(
ma_kieu_thue int  PRIMARY KEY,
ten_kieu_thue varchar(45)
);

CREATE TABLE dich_vu(
ma_dich_vu int  primary key,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
dich_vu_mien_phi_di_kem text,
FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu),
FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue)
);

CREATE TABLE dich_vu_di_kem(
ma_dich_vu_di_kem int  primary key,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45));

CREATE TABLE hop_dong(
ma_hop_dong int primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu));

CREATE TABLE hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int primary key,
ma_hop_dong int,
FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
ma_dich_vu_di_kem int,
FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem),
so_luong int);
