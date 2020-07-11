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
INSERT INTO car values(1 , 'Limuzina' , 'Gas', 2 , 'bmw' , 15124 , 'X1' , 'KL1234' , 1234567891 , 5 , 1234 , 123 , 'Auto',1 );
INSERT INTO car values(2 , 'Limuzina' , 'Gas', 2 , 'bmw' , 15124 , 'X1' , 'KL1234' , 1234567891 , 5 , 1234 , 123 , 'Auto',1 );
--cjenovnici
INSERT INTO price_list values(20 , 239 , 20 ,5) ;
INSERT INTO price_list values(21 , 249 , 10 , 3) ;