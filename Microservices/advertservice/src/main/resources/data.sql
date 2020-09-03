CREATE SEQUENCE car_seq
start with 1
increment by 1
minvalue 0
maxvalue 100
cycle;


insert into car_fuel values(1,'benzin');
insert into car_fuel values(2,'dizel');
insert into car_fuel values(3,'gas');
insert into transmission values(1,'automatik');
insert into transmission values(2,'manuelni');
insert into transmission values(3,'poluautomatski');

--korisnici
insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(10,'vozacke', 'email','srks','kralj','Srdjan', 'Simic', 'adresa_s','grad_s','zemlja_s');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(20,'vozacke', 'email','nidza','solidni','Nikola', 'Artukov', 'adresa_n','grad_n','zemlja_n');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(30,'vozacke', 'email','markaya','macor','Marko', 'Ristic', 'adresa_m','grad_m','zemlja_m');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(40,'vozacke', 'email','mica','lavanda','Milica', 'Svonja', 'adresa_mm','grad_mm','zemlja_mm');


--automobili
insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id)
values(10,'BMW','X5','SUV',1,1,20,'aaa',1,50 ,10);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(20,'Mercedes','Vitto','Karavan',1,2,10,'aaa',2,500 ,10);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(123,'Mercedes','Ajkula','Limuzina',2,2,10,'aaa',1,500 ,10);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(40,'Skoda','Oktavija','Karavan',1,3,20,'aaa',1,0 ,10);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )

values(50,'Skoda','Oktavija','Fabija',3,2,200,'aaa',1,0 ,20);



insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage,user_id )
values(60,'Skoda','Oktavija','Fabija',3,2,200,'aaa',1,0 ,20);
--cjenovnici

INSERT INTO price_list(id, price_per_day,price_per_kilometer,pricecdw,user_id) values(123 , 239 , 20 ,5,10) ;
INSERT INTO price_list(id, price_per_day,price_per_kilometer,pricecdw,user_id) values(21 , 249 , 10 , 3,20) ;

