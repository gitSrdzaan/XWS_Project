import CarFuel from './carFuel.model';
import Transmission from './transmission.model';
export default class Car {
  id: number;
  carRegistration: string;
  carMark: string;
  carModel: string;
  carFuel: string;
  transmission: string;
  carClass: string;
  carMileage: number;
  carGrade: number;
  kidsSeats: number;

  constructor() {
    this.id = null;
    this.carRegistration = null;
    this.carMark = null;
    this.carModel = null;
    this.carFuel = null;
    this.transmission = null;
    this.carClass = null;
    this.carMileage = null;
    this.carGrade = null;
    this.kidsSeats = null;
  }
}
