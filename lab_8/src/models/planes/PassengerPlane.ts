import { Plane } from "./Plane";

export class PassengerPlane extends Plane {
  constructor(
    model: string,
    maxSpeed: number,
    maxFlightDistance: number,
    maxLoadCapacity: number,
    private passengersCapacity: number
  ) {
    super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
  }

  public getPassengersCapacity() {
    return this.passengersCapacity;
  }

  public setPassengersCapacity(value: number) {
    this.passengersCapacity = value;
  }
}
