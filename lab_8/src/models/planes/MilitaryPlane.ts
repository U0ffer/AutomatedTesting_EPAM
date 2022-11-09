import { MilitaryType } from "../../enums/MilitaryType";
import { Plane } from "./Plane";

export class MilitaryPlane extends Plane {
  constructor(
    model: string,
    maxSpeed: number,
    maxFlightDistance: number,
    maxLoadCapacity: number,
    private militaryType: MilitaryType
  ) {
    super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
  }

  public getMilitaryType() {
    return this.militaryType;
  }
}
