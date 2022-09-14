DROP database if exists sell_manager;
CREATE database sell_manager;
USE sell_manager;

CREATE TABLE customer(
customer_id int auto_increment primary key,
name varchar(25),
customer_age tinyint);

CREATE TABLE `order`(
order_id int auto_increment primary key,
customer_id int,
order_date datetime,
order_total_price int,
foreign key(customer_id) references customer(customer_id));

CREATE TABLE  product(
product_id int auto_increment primary key,
product_name varchar(25),
product_price int);

CREATE TABLE order_detail(
order_id int,
product_id int,
order_QTY int,
foreign key(order_id) references `order`(order_id),
foreign key(product_id) references product(product_id));

insert into customer( name, customer_age)
value ("Minh Quan",10);
insert into customer( name, customer_age)
value ("Ngoc Oanh",20);
insert into customer( name, customer_age)
value ("Hong Ha",30);

insert into `order`(customer_id, order_date, order_total_price)
value (1, "2006-3-21" , null);
insert into `order`(customer_id, order_date, order_total_price)
value (2, "2006-3-23" , null);
insert into `order`(customer_id, order_date, order_total_price)
value (1, "2006-3-16" , null);

insert into product(product_name, product_price)
value ("May Giat" , 3);
insert into product(product_name, product_price)
value ("Tu Lanh" , 5);
insert into product(product_name, product_price)
value ("Dieu Hoa" , 7);
insert into product(product_name, product_price)
value ("Quat" , 1);
insert into product(product_name, product_price)
value ("Bep Dien" , 2);

insert into order_detail(order_id, product_id, order_QTY)
value (1,1,3);
insert into order_detail(order_id, product_id, order_QTY)
value (1,3,7);
insert into order_detail(order_id, product_id, order_QTY)
value (1,4,2);
insert into order_detail(order_id, product_id, order_QTY)
value (2,1,1);
insert into order_detail(order_id, product_id, order_QTY)
value (3,1,8);
insert into order_detail(order_id, product_id, order_QTY)
value (2,5,4);
insert into order_detail(order_id, product_id, order_QTY)
value (2,3,3);

select order_id , order_date , order_total_price from `order`;
-- select customer.name  , product.product_name 
-- from customer , `order` , product , order_detail where customer.customer_id = `order`.customer_id and 
--   product.product_id = order_detail.product_id;
select customer.name from customer join `order` on customer.customer_id = `order`.customer_id group by customer.customer_id;

select product.product_name from product join order_detail on product.product_id = order_detail.product_id group by product.product_name;

select customer.name from customer where customer.customer_id not in ( select `order`.customer_id from `order`); 

select `order`.order_id , `order`.order_date , sum(product.product_price * order_detail.order_QTY) as total_price from `order` 
join order_detail on `order`.order_id = order_detail.order_id
join product on product.product_id = order_detail.product_id group by `order`.order_id;
