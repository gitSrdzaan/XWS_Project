
insert into car_mark values(1,'BMW');
insert into car_model values(1,'X5',1);
insert into car_class values(1,'SUV');
insert into model_class values(1,1);
insert into firm values(123 , 'mifa' , 'fafsa' , 'ffsafa' , 'fasfa' , 'ffasfsa');


insert into firm(id,pib,firm_name,firm_city,firm_country,firm_adress) values(1, 'pib','name', 'city','country', 'adress');
insert into firm(id,pib,firm_name,firm_city,firm_country,firm_adress) values(2, 'pib2','name2', 'city2','country2', 'adress2');
insert into firm(id,pib,firm_name,firm_city,firm_country,firm_adress) values(3, 'pib3','name3', 'city3','country3', 'adress3');
insert into firm(id,pib,firm_name,firm_city,firm_country,firm_adress) values(4, 'pib4','name4', 'city4','country4', 'adress4');
insert into firm(id,pib,firm_name,firm_city,firm_country,firm_adress) values(5, 'pib5','name5', 'city5','country5', 'adress5');


insert into car(id , car_class , car_fuel , car_grade , car_mark , car_mileage , car_model , car_registration , kids_seats , max_allowed_mileage ,
transmission) values (123,'SUV','dizel', 2,'BMW',0.0,'X5','registration',0,500,'manuel');

insert into price_list(id,price_per_day, price_per_kilometer, pricecdw,firm_id)
values(123,2,4,60,123);

insert into rent_advert(id ,advert_start_date,advert_end_date, car_id , firm , pricelist_id)
values(123,parsedatetime('05-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
123,123,123);

insert into car_fuel values(1,'benzin');
insert into car_fuel values(2,'dizel');
insert into car_fuel values(3,'gas');
insert into car_fuel values(4,'struja');
insert into transmission values(1,'automatik');
insert into transmission values(2,'manuelni');
insert into transmission values(3,'poluautomatski');


insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(10,'vozacke', 'email','srks','kralj','Srdjan', 'Simic', 'adresa_s','city','country');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(20,'vozacke', 'email','nidza','solidni','Nikola', 'Artukov', 'adresa_n','grad_n','zemlja_n');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(30,'vozacke', 'email','markaya','macor','Marko', 'Ristic', 'adresa_m','grad_m','zemlja_m');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(40,'vozacke', 'email','mica','lavanda','Milica', 'Svonja', 'adresa_mm','grad_mm','zemlja_mm');

--automobili
insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(1,'BMW','X5','SUV','1','1',20,'aaa',1,50 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(2,'Mercedes','Vitto','Karavan','1','2',10,'aaa',2,500 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(3,'Mercedes','Ajkula','Limuzina','2','2',10,'aaa',1,500 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(4,'Skoda','Oktavija','Karavan','1','3',20,'aaa',1,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(5,'Skoda','Oktavija','Fabija','3','2',200,'aaa',1,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(6,'Skoda','Favorit','Favorit','3','2',200,'aaa',1,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(7,'Audi','A5','Karavan','2','1',200,'aaa',2,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage )
values(8,'Maserati','A8','Karavan','1','3',100,'aaa',0,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage )
values(9,'Ferrari','X5','Dvosed','3','3',100,'aaa',0,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage )
values(10,'Lamborghini','X2','Dvosed','3','2',100,'aaa',0,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage )
values(11,'Tesla','Elektricna','Dvosed','4','2',100,'aaa',0,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(12,'Skoda','Fobia','Dvosed','2','1',10,'aaa',2,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage )
values(13,'Renault','F1','Bolid','2','1',10,'aaa',2,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage)
values(14,'Chrysler','Cruiser','30','2','1',10,'aaa',2,0 );

insert into car(id,car_mark,car_model,car_class, car_fuel,transmission, car_mileage,
car_registration, kids_seats,max_allowed_mileage )
values(15,'Aaston Martin','P200','C','2','1',10,'aaa',2,1 );

--cjenovnika
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(1,2,4,60);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(2,4,6,80);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(3,6,8,100);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(4,4,12,80);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(5,7,2,30);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(6,4,3,120);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(7,1,6,10);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(8,10,6,10);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(9,7,16,10);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(10,5,10,20);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(11,15,10,20);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(12,2,1,20);
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw)
values(13,5,10,20);
--reklame
insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(1,parsedatetime('05-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(2,parsedatetime('06-07-2020 11:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('09-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(3,parsedatetime('15-07-2020 03:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('20-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
3,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(4,parsedatetime('11-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(5,parsedatetime('05-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
4,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(6,parsedatetime('05-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,3);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(7,parsedatetime('05-10-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-10-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
6,2);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(8,parsedatetime('05-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
7,4);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(9,parsedatetime('02-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('29-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
8,5);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(10,parsedatetime('05-12-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-12-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
9,6);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(11,parsedatetime('09-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('19-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
10,7);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(12,parsedatetime('22-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('05-12-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
11,8);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(13,parsedatetime('20-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('03-12-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
12,9);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(14,parsedatetime('20-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('03-10-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
13,10);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(15,parsedatetime('20-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('03-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
14,11);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(16,parsedatetime('10-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('23-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
15,12);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(17,parsedatetime('16-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('25-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(18,parsedatetime('26-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('04-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(19,parsedatetime('05-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('10-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(20,parsedatetime('10-07-2020 11:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('12-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(21,parsedatetime('13-07-2020 11:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(22,parsedatetime('18-07-2020 11:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('25-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(23,parsedatetime('26-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('01-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,13);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(24,parsedatetime('06-08-2020 11:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('09-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(25,parsedatetime('21-07-2020 03:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('23-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
3,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(26,parsedatetime('25-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('30-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
3,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(27,parsedatetime('01-08-2020 03:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('05-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
3,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(28,parsedatetime('16-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(29,parsedatetime('16-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-10-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,pricelist_id )
values(30,parsedatetime('16-10-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-11-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1);

