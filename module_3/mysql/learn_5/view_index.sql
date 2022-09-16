drop database if exists product_management;
create database product_management ;
use product_management ;
create table product(
id int auto_increment primary key ,
productCode int,
productName varchar(50),
productPrice double,
productAmount int,
productDescription varchar(50),
productStatus varchar(50));
insert into product(productCode , productName , productPrice, productAmount ,productDescription, productStatus)
value (1, "iphone" , 5000 , 5 , "iphone 14" , "cháy hàng "),
      (2, "apple" , 5000 , 15 , "iphone 14" , "cháy hàng "),
      (3, "nokia" , 5000 , 25 , "iphone 14" , "cháy hàng "),
      (4, "samsum" , 5000 , 4 , "iphone 14" , "cháy hàng "),
      (5, "cục gạch" , 5000 , 5 , "iphone 14" , "cháy hàng "),
      (6, "apple" , 5000 , 6 , "iphone 14" , "cháy hàng "),
      (7, "iphone 3" , 5000 , 8 , "iphone 14" , "cháy hàng "),
      (8, "iphone 4" , 5000 , 9 , "iphone 14" , "cháy hàng "),
      (9, "iphone 5" , 5000 , 7 , "iphone 14" , "cháy hàng "),
      (10, "iphone 6" , 5000 , 4 , "iphone 14" , "cháy hàng "),
      (11, "iphone 7", 5000 , 1 , "iphone 14" , "cháy hàng "),
      (16, "iphone 8" , 5000 , 2 , "iphone 14" , "cháy hàng "),
      (17, "iphone 9" , 5000 , 3 , "iphone 14" , "cháy hàng "),
      (18, "iphone 10" , 5000 , 6 , "iphone 14" , "cháy hàng "),
      (19, "apple store" , 5000 , 51 , "iphone 14" , "cháy hàng "),
      (20, "apple watch" , 5000 , 10 , "iphone 14" , "cháy hàng "),
      (21, "mac book" , 5000 , 24 , "iphone 14" , "cháy hàng "),
      (22, "asus" , 5000 , 5 , "iphone 14" , "cháy hàng "),
      (23, "dell" , 5000 , 5 , "iphone 14" , "cháy hàng "),
      (24, "H-P" , 5000 , 5 , "iphone 14" , "cháy hàng "),
      (25, "vivo book" , 3000 , 5 , "iphone 13" , "tồn kho"),
      (26, "galaxy s14" , 3000 , 5 , "iphone 13" , "tồn kho"),
      (27, "apple 1" , 3000 , 5 , "iphone 13" , "tồn kho"),
      (28, "apple 3" , 3000 , 5 , "iphone 13" , "tồn kho"),
      (29, "apple 4" , 3000 , 5 , "iphone 13" , "tồn kho"),
      (30, "apple 14" , 3000 , 5 , "iphone 13" , "tồn kho");
	EXPLAIN SELECT * FROM product WHERE productcode = 25;
	CREATE UNIQUE INDEX index_productcode ON product(productcode);
	Explain SELECT * FROM product WHERE productcode =25;
    SELECT * FROM product WHERE productname = "apple 3" AND productprice = 3000;
    CREATE INDEX index_composite ON product(productname,productprice);
    EXPLAIN SELECT * FROM product WHERE productname = "apple 3" AND productprice = 3000;
    DROP VIEW IF EXISTS product_view;
    CREATE VIEW  product_view AS SELECT productCode, productName, productPrice, productStatus FROM product ;
	SELECT * FROM product_view;
    update product_view
    set productStatus = "tồn kho" where productcode=1;
    DROP VIEW product_view;
    -- tạo store procedure
    Delimiter //
Create Procedure all_records()
    BEGIN
    Select * from product;
    END//
DELIMITER ;
CALL all_records();
    -- Tạo store procedure thêm một sản phẩm mới
    Delimiter //
Create Procedure add_record(in product_code int, product_name varchar(50), product_price double, product_amount int, product_description varchar(50), product_status varchar(20))
    BEGIN
	INSERT INTO product (productcode, productname, productprice, productamount, productdescription,productstatus) VALUES (product_code,product_name,product_price,product_amount,product_description,product_status);
    END//
DELIMITER ;
    CALL add_record(31,'apple 15',6000,5,"iphone","tham hoa");
    -- Tạo store procedure sửa thông tin chi tiết của sản phẩm theo id
    Delimiter //
Create Procedure edit_record(in p_id INT, p_product_description varchar(50))
    BEGIN
    update product
    set productdescription = p_product_description where id = p_id;
    END//
DELIMITER ;
   CALL edit_record(1,"ok");
   CALL edit_record(1,"Not OK");
   -- Tạo store procedure xoá sản phẩm theo id
   Delimiter //
Create Procedure delete_record(in p_id INT)
    BEGIN
    delete from product where id = p_id;
    END//
DELIMITER ;
CALL delete_record(1);

      
      
