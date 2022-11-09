export abstract class Plane {
  constructor(
    private model: string,
    private maxSpeed: number,
    private maxFlightDistance: number,
    private maxLoadCapacity: number
  ) {}

  public getModel() {
    return this.model;
  }

  public getMaxSpeed() {
    return this.maxSpeed;
  }

  public getMaxFlightDistance() {
    return this.maxFlightDistance;
  }

  public getMaxLoadCapacity() {
    return this.maxLoadCapacity;
  }
}
