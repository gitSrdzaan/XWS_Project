insert into car_fuel values(1,'benzin');
insert into car_fuel values(2,'dizel');
insert into car_fuel values(3,'gas');
insert into transmission values(1,'automatik');
insert into transmission values(2,'manuelni');
insert into transmission values(3,'poluautomatski');

--korisnici
insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(1,'vozacke', 'email','srks','kralj','Srdjan', 'Simic', 'adresa_s','grad_s','zemlja_s');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(2,'vozacke', 'email','nidza','solidni','Nikola', 'Artukov', 'adresa_n','grad_n','zemlja_n');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(3,'vozacke', 'email','markaya','macor','Marko', 'Ristic', 'adresa_m','grad_m','zemlja_m');

insert into user(id,drivers_licence,email,username,password,name,surname,user_adress,user_city,user_country)
values(4,'vozacke', 'email','mica','lavanda','Milica', 'Svonja', 'adresa_mm','grad_mm','zemlja_mm');


--automobili
insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id)
values(1,'BMW','X5','SUV',1,1,20,'aaa',1,50 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(2,'Mercedes','Vitto','Karavan',1,2,10,'aaa',2,500 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(3,'Mercedes','Ajkula','Limuzina',2,2,10,'aaa',1,500 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(4,'Skoda','Oktavija','Karavan',1,3,20,'aaa',1,0 ,1);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage, user_id )
values(5,'Skoda','Oktavija','Fabija',3,2,200,'aaa',1,0 ,2);

insert into car(id,car_mark,car_model,car_class, carfuel_id,transmission_id, car_mileage,
car_registration, kids_seats,max_allowed_mileage,user_id )
values(6,'Skoda','Oktavija','Fabija',3,2,200,'aaa',1,0 ,2);
--cjenovnici
INSERT INTO price_list values(20 , 239 , 20 ,5,1) ;
INSERT INTO price_list values(21 , 249 , 10 , 3,2) ;