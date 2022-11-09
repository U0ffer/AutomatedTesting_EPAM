import { ClassificationLevel } from "../../enums/ClassificationLevel";
import { ExperimentalType } from "../../enums/ExperimentalType";
import { Plane } from "./Plane";

export class ExperimentalPlane extends Plane {
  constructor(
    model: string,
    maxSpeed: number,
    maxFlightDistance: number,
    maxLoadCapacity: number,
    private type: ExperimentalType,
    private classificationLevel: ClassificationLevel
  ) {
    super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
  }

  public getType(): ExperimentalType {
    return this.type;
  }

  public getClassificationLevel(): ClassificationLevel {
    return this.classificationLevel;
  }
}
