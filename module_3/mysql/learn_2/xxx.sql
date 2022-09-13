CREATE DATABASE learn_2;
USE lear_2;

CREATE TABLE customer(
customer_id int auto_increment primary key,
name varchar(45),
age int);

CREATE TABLE orderProduct(
customer_id int ,
bill_id int primary key,
order_date date,
total_price double,
foreign key (customer_id) references customer(customer_id));

CREATE TABLE product(
 product_id int auto_increment primary key,
 product_name varchar(50),
 product_price double);

CREATE TABLE orderDetail(
bill_id int ,
product_id int,
chat_lieu_san_pham varchar(45),
primary key (bill_id , product_id),
foreign key (bill_id) references orderproduct(bill_id),
foreign key (product_id) references product(product_id));
 
