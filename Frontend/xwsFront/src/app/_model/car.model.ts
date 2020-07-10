import CarFuel from './carFuel.model';
import Transmission from './transmission.model';
export default class Car {
  id: number;
  carRegistration: string;
  carMark: string;
  carModel: string;
  carFuel: CarFuel;
  transmission: Transmission;
  carClass: string;
  carMileage: number;
  carGrade: number;
  kidsSeats: number;
}
