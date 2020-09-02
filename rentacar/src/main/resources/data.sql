insert into car_mark values(1,'BMW');
insert into car_model values(1,'X5',1);
insert into car_class values(1,'SUV');
insert into model_class values(1,1);
insert into car_fuel values(1,'dizel');
insert into transmission values(1,'manuelni');
insert into firm values(123 , 'mifa' , 'fafsa' , 'ffsafa' , 'fasfa' , 'ffasfsa');


insert into car(id , car_class , car_fuel , car_grade , car_mark , car_mileage , car_model , car_registration , kids_seats , max_allowed_mileage ,
transmission) values (123,'SUV','dizel', 2,'BMW',0.0,'X5','registration',0,500,'manuel');

insert into price_list(id,price_per_day, price_per_kilometer, pricecdw,firm_id)
values(123,2,4,60,123);

insert into rent_advert(id ,advert_start_date,advert_end_date, car_id , firm , price_list_id)
values(123,parsedatetime('05-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('15-07-2020 12:00:00.001', 'dd-MM-yyyy hh:mm:ss.SS'),
123,123,123);
