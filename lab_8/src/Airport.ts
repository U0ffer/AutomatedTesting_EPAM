import { MilitaryType } from "./enums/MilitaryType";
import { ExperimentalPlane } from "./models/planes/ExperimentalPlane";
import { MilitaryPlane } from "./models/planes/MilitaryPlane";
import { PassengerPlane } from "./models/planes/PassengerPlane";
import { Plane } from "./models/planes/Plane";

export class Airport {
  constructor(private readonly _planes: Plane[]) {}

  public static print(data: Plane | Plane[]) {
    return JSON.stringify(data);
  }

  public getPlanes(): Plane[] {
    return this._planes;
  }

  public getPassengerPlanes(): PassengerPlane[] {
    return this._planes.filter(
      (plane) => plane instanceof PassengerPlane
    ) as PassengerPlane[];
  }

  public getMilitaryPlanes(): MilitaryPlane[] {
    return this._planes.filter(
      (plane) => plane instanceof MilitaryPlane
    ) as MilitaryPlane[];
  }

  public getExperimentalPlanes(): ExperimentalPlane[] {
    return this._planes.filter(
      (plane) => plane instanceof ExperimentalPlane
    ) as ExperimentalPlane[];
  }

  public getTransportMilitaryPlanes(): MilitaryPlane[] {
    return this.getMilitaryPlanes().filter(
      (plane) => plane.getMilitaryType() === MilitaryType.TRANSPORT
    );
  }

  public getBomberMilitaryPlanes(): MilitaryPlane[] {
    return this.getMilitaryPlanes().filter(
      (plane) => plane.getMilitaryType() === MilitaryType.BOMBER
    );
  }

  public getPassengerPlaneWithMaxPassengersCapacity(): PassengerPlane {
    return this.getPassengerPlanes().reduce((prev, current) =>
      prev.getMaxLoadCapacity() > current.getPassengersCapacity()
        ? prev
        : current
    );
  }

  public sortByMaxDistance(): Plane[] {
    return this._planes.sort((current, next) =>
      current.getMaxFlightDistance() > next.getMaxFlightDistance() ? 1 : -1
    );
  }

  public sortByMaxSpeed(): Plane[] {
    return this._planes.sort((current, next) =>
      current.getMaxSpeed() > next.getMaxSpeed() ? 1 : -1
    );
  }

  public sortByMaxLoadCapacity(): Plane[] {
    return this._planes.sort((current, next) =>
      current.getMaxLoadCapacity() > next.getMaxLoadCapacity() ? 1 : -1
    );
  }
}
