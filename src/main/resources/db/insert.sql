set foreign_key_checks=0;


truncate  table  product;
truncate table feedback;

insert into product(`id`, `name`, `price`, `details`, `currency`)
values(110, 'luxury chair', 4500, 'Lorem Ipsum is ,simply dummy text of', 'SRC'),
       (111,'luxury sofa', 4000, 'Lorem Ipsum is ,simply dummy text of', 'USD'),
       (112, 'luxury bench', 6500, 'Lorem Ipsum is ,simply dummy text of', 'NGN'),
       (113, 'luxury table', 8500, 'Lorem Ipsum is ,simply dummy text of', 'NGN');

set foreign_key_checks=1;
