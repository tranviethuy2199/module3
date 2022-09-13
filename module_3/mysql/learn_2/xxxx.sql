CREATE database learn_3;

create table nha_cung_cap(
ma_ncc int primary key,
ten_ncc varchar(45),
dia_chi varchar(45),
sdt int
); 
create table vat_tu(
ma_vat_tu int primary key,
ten_vat_tu varchar(45)
);
create table don_dat_hang(
so_don_hang int primary key,
ngay_nhap_don_hang datetime,
 ma_ncc int,
 foreign key(ma_ncc) references nha_cung_cap(ma_ncc)
);
create table chi_tiet_don_dat_hang(
ma_vat_tu int,
so_don_hang int,
primary key(ma_vat_tu, so_don_hang),
ngay_nhap_don_hang datetime,
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_don_hang) references don_dat_hang(so_don_hang)
);
create table phieu_nhap(
so_phieu_nhap int primary key,
ngay_nhap datetime
);
create table chi_tiet_phieu_nhap(
ma_vat_tu int,
so_phieu_nhap int,
primary key(ma_vat_tu,so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
);
create table phieu_xuat(
so_phieu_xuat int primary key,
ngay_xuat datetime
);
create table chi_tiet_phieu_xuat(
ma_vat_tu int,
so_phieu_xuat int,
primary key(ma_vat_tu,so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat)
);
