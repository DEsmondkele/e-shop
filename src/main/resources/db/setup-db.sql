create  database shopdb;

create  user 'shop_user'@'localhost' identified by 'shop123'
grant all privileges  shopdb.* to 'shop_user'@'localhost';
flush privileges ;