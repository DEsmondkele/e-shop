create  database storedb;

create  user 'shop_user'@'localhost' identified by 'shop123'
grant all privileges  storedb.* to 'shop_user'@'localhost';
flush privileges ;