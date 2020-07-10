insert into firm(id,pib,firm_name,firm_city,firm_country,firm_adress) values(1, 'pib','name', 'city','country', 'adress');
insert into car_fuel values(1,'benzin');
insert into car_fuel values(2,'dizel');
insert into car_fuel values(3,'gas');
insert into transmission values(1,'automatik');
insert into transmission values(2,'manuelni');
insert into transmission values(3,'poluautomatski');

--automobili
insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, firm_id)
values(1,'BMW','X5','SUV',1,1,20,'aaa',1,50 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, firm_id )
values(2,'Mercedes','Vitto','Karavan',1,2,10,'aaa',2,500 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, firm_id )
values(3,'Mercedes','Ajkula','Limuzina',2,2,10,'aaa',1,500 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, firm_id )
values(4,'Skoda','Oktavija','Karavan',1,3,20,'aaa',1,0 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, firm_id )
values(5,'Skoda','Oktavija','Fabija',3,2,200,'aaa',1,0 ,1);
--cjenovnika
insert into price_list(id,price_per_day, price_per_kilometer, pricecdw,firm_id)
values(1,2,4,60,1);
--reklame
insert into rent_advert(id,advert_start_date,advert_end_date,car_id,firm,pricelist_id )
values(1,parsedatetime('05-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
1,1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,firm,pricelist_id )
values(2,parsedatetime('06-07-2020 11:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('09-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,firm,pricelist_id )
values(3,parsedatetime('15-07-2020 03:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('20-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
3,1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,firm,pricelist_id )
values(4,parsedatetime('11-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-08-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
2,1,1);

insert into rent_advert(id,advert_start_date,advert_end_date,car_id,firm,pricelist_id )
values(5,parsedatetime('05-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-09-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
4,1,1);