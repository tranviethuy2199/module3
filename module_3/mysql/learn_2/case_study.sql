DROP DATABASE IF EXISTS furama;
CREATE DATABASE  furama;
USE furama;
CREATE TABLE  vi_tri(
ma_vi_tri INT PRIMARY KEY,
ten_vi_tri VARCHAR(45)
);
CREATE TABLE trinh_do(
ma_trinh_do INT PRIMARY KEY,
ten_trinh_do VARCHAR(45)
);
CREATE TABLE bo_phan(
ma_bo_phan INT PRIMARY KEY,
ten_bo_phan VARCHAR(45)
);
CREATE TABLE nhan_vien(
ma_nhan_vien INT PRIMARY KEY,
ho_ten VARCHAR(45),
ngay_sinh DATE,
so_cmnd VARCHAR(45),
luong DOUBLE,
so_dien_thoai VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45),
ma_vi_tri INT,
FOREIGN KEY (ma_vi_tri)
REFERENCES vi_tri (ma_vi_tri),
ma_trinh_do INT,
FOREIGN KEY (ma_trinh_do)
REFERENCES trinh_do (ma_trinh_do),
ma_bo_phan INT,
FOREIGN KEY (ma_bo_phan)
REFERENCES bo_phan(ma_bo_phan)
);
CREATE TABLE  loai_khach(
ma_loai_khach INT PRIMARY KEY,
ten_loai_khach VARCHAR(45)
);
CREATE TABLE  khach_hang(
ma_khach_hang INT PRIMARY KEY,
ma_loai_khach INT,
FOREIGN KEY (ma_loai_khach)
REFERENCES loai_khach(ma_loai_khach),
ho_ten VARCHAR(45),
ngay_sinh DATE,
gioi_tinh BIT(1),
so_cmnd VARCHAR(45),
so_dien_thoai VARCHAR(45) PRIMARY KEY,
email VARCHAR(45),
dia_chi VARCHAR(45)
);
CREATE TABLE loai_dich_vu(
ma_loai_dich_vu INT PRIMARY KEY,
ten_loai_dich_vu VARCHAR(45)
);
CREATE TABLE kieu_thue(
ma_kieu_thue INT PRIMARY KEY,
ten_kieu_thue VARCHAR(45)
);
CREATE TABLE dich_vu(
ma_dich_vu INT PRIMARY KEY,
ten_dich_vu VARCHAR(45),
dien_tich INT,
chi_phi_thue DOUBLE,
so_nguoi_toi_da INT,
ma_kieu_thue INT,
FOREIGN KEY (ma_kieu_thue) 
REFERENCES kieu_thue(ma_kieu_thue),
ma_loai_dich_vu INT,
FOREIGN KEY (ma_loai_dich_vu)
REFERENCES loai_dich_vu(ma_loai_dich_vu),
tieu_chuan_phong VARCHAR(45),
mo_ta_tien_nghi_khac VARCHAR(45),
dien_tich_ho_boi VARCHAR(45),
so_tang INT,
dich_vu_mien_phi_di_kem TEXT
);
CREATE TABLE  hop_dong(
ma_hop_dong INT PRIMARY KEY,
ngay_lam_hop_dong DATETIME,
ngay_ket_thuc DATETIME,
tien_dat_coc DOUBLE,
ma_nhan_vien INT,
FOREIGN KEY (ma_nhan_vien) 
REFERENCES nhan_vien(ma_nhan_vien),
ma_khach_hang INT,
FOREIGN KEY (ma_khach_hang)
REFERENCES khach_hang(ma_khach_hang),
ma_dich_vu INT,
FOREIGN KEY (ma_dich_vu)
REFERENCES dich_vu(ma_dich_vu)
);
 
CREATE TABLE  dich_vu_di_kem(
ma_dich_vu_di_kem INT PRIMARY KEY,
ten_dich_vu_di_kem VARCHAR(45),
gia DOUBLE,
don_vi VARCHAR(45),
trang_thai VARCHAR(45)
);
CREATE TABLE  hop_dong_chi_tiet(
ma_hop_dong_chi_tiet INT PRIMARY KEY,
ma_hop_dong INT,
FOREIGN KEY (ma_hop_dong)
REFERENCES hop_dong(ma_hop_dong),
ma_dich_vu_di_kem INT,
FOREIGN KEY (ma_dich_vu_di_kem)
REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem),
so_luong INT
);
INSERT INTO vi_tri(ma_vi_tri,ten_vi_tri)
VALUE(1,'Qu???n l??'),(2,'Nh??n vi??n');
INSERT INTO trinh_do(ma_trinh_do,ten_trinh_do)
VALUE(1,"Trung C???p"),(2,"Cao ?????ng"),(3,"?????i H???c"),(4,"Sau ?????i H???c");
INSERT INTO bo_phan(ma_bo_phan,ten_bo_phan)
VALUE(1,"Sale-Marketing"),(2,"H??nh Ch??nh"),(3,"Ph???c v???"),(4,"Qu???n L??");
INSERT INTO nhan_vien(ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do,ma_bo_phan) 
VALUES ('1', 'Nguy???n V??n An', '1970-11-07', '456231786', '10000000', '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng', '1', '3', '1'),
(2, 'L?? V??n B??nh', '1997-04-09', '654231234', '7000000', '0934212314', 'binhlv@gmail.com', '22 Y??n B??i, ???? N???ng', '1', '2', '2'),
(3, 'H??? Th??? Y???n', '1995-12-12', '999231723', '14000000', '0412352315', 'thiyen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', '1', '3', '2'),
(4, 'V?? C??ng To???n', '1980-04-04', '123231365', '17000000', '0374443232', 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', '1', '4', '4'),
 (5, 'Nguy???n B???nh Ph??t', '1999-12-09', '454363232', '6000000', '0902341231', 'phatphat@gmail.com', '43 Y??n B??i, ???? N???ng', '2', '1', '1'),
(6, 'Kh??c Nguy???n An Nghi', '2000-11-08', '964542311', '7000000', '0978653213', 'annghi20@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', '2', '2', '3'),
(7, 'Nguy???n H???u H??', '1993-01-01', '534323231', '8000000', '0941234553', 'nhh0101@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', '2', '3', '2'),
(8, 'Nguy???n H?? ????ng', '1989-09-03', '234414123', '9000000', '0642123111', 'donghanguyen@gmail.com', '111 H??ng V????ng, H?? N???i', '2', '4', '4'),
(9, 'T??ng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 H??m Nghi, ???? N???ng', '2', '4', '4'),
(10, 'Nguy???n C??ng ?????o', '1994-01-08', '755434343', '8000000', '0988767111', 'nguyencongdao12@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', '2', '3', '2');
INSERT INTO loai_khach(ma_loai_khach,ten_loai_khach)
VALUE(1,"Diamond"),(2,"Platinium"),(3,"Gold"),(4,"Silver"),(5,"Member");
INSERT INTO khach_hang(ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) 
VALUES (1, 'Nguy???n Th??? H??o','1970-11-07', 0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng',5),
(2, 'Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0954333333','xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???',3),
(3, 'Tr????ng ????nh Ngh???', '1990-02-27', 1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh',1),
(4, 'D????ng V??n Quan', '1981-07-08', 1,'543432111','0490039241','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng',1),
(5, 'Ho??ng Tr???n Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai',4),
(6, 'T??n N??? M???c Ch??u','2005-12-06', 0,'732434215','0988888844','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng','4'),
(7, 'Nguy???n M??? Kim','1984-04-08', 0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh',1),
(8, 'Nguy???n Th??? H??o','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum',3),
(9,'Tr???n ?????i Danh','1994-07-01', 1,'432341235','0643343433','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i',1),
(10, 'Nguy???n T??m ?????c','1989-07-01', 1,'344343432','0987654321','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng',2);
INSERT INTO kieu_thue(ma_kieu_thue,ten_kieu_thue)
VALUE(1,'year'),(2,'month'),(3,'day'),(4,'hour');
INSERT INTO loai_dich_vu(ma_loai_dich_vu,ten_loai_dich_vu)
VALUE(1,'Villa'),(2,'House'),(3,'Room');
INSERT INTO dich_vu(ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, dich_vu_mien_phi_di_kem)
 VALUES (1, 'Villa Beach Front', 25000, 1000000, 10, 3, 1, 'vip', 'C?? h??? b??i', 500, 4, null),
(2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'C?? th??m b???p n?????ng', null, 3, null),
(3, 'Room Twin 01', 5000, 1000000, 2,4, 3, 'normal', 'C?? tivi', null, null, '1 Xe m??y, 1 Xe ?????p'),
(4, 'Villa No Beach Front', 22000, '9000000', '8', '3', '1', 'normal', 'C?? h??? b??i', 300, 3, null),
(5, 'House Princess 02', 10000, '4000000', 5, 3, 2, 'normal', 'C?? th??m b???p n?????ng', null, 2, null),
(6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'C?? tivi', null, null, '1 Xe m??y');
INSERT INTO dich_vu_di_kem (ma_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai) 
VALUES (1, 'Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n t???i'),
(2, 'Thu?? xe m??y', 10000, 'chi???c', 'h???ng 1 xe'),
(3, 'Thu?? xe ?????p', 20000, 'chi???c', 't???t'),
(4, 'Buffet bu???i s??ng', 15000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
(5, 'Buffet bu???i tr??a', 90000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
(6, 'Buffet bu???i t???i', 16000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng');
INSERT INTO hop_dong(ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
VALUES (1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
(2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1),
(3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2),
(4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5),
(5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
(6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
(7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
(8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
(9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
(10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
(11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
(12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
INSERT INTO hop_dong_chi_tiet(ma_hop_dong_chi_tiet,ma_hop_dong,ma_dich_vu_di_kem,so_luong)
VALUE(1,2,4,5),(2,2,5,8),(3,2,6,15),(4,3,1,1),(5,3,2,11),(6,1,3,1),(7,1,2,2),(8,12,2,2);
SELECT * FROM nhan_vien WHERE (ho_ten like'T%' OR ho_ten LIKE 'H%' OR ho_ten LIKE 'K%') AND char_length(ho_ten)<15;
-- SELECT * FROM nhan_vien WHERE (ho_ten regexp ^[HKT]) AND char_length(ho_ten)<15;
SELECT * FROM khach_hang WHERE (TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) BETWEEN 18 AND 50) AND (dia_chi LIKE '%???? N???ng%' or dia_chi LIKE '%Qu???ng Tr???%');
-- SELECT khach_hang.ma_khach_hang , khach_hang.ho_ten , COUNT(hop_dong.ma_khach_hang) FROM khach_hang.hop_dong 
-- where (khach_hang.ma_loai_khach = 1) AND (khach_hang.ma_khac_hang = khach_hang.ma_hop_dong));