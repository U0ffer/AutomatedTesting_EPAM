import { assert } from "chai";
import { Airport } from "../src/Airport";
import { ClassificationLevel } from "../src/enums/ClassificationLevel";
import { ExperimentalType } from "../src/enums/ExperimentalType";
import { MilitaryType } from "../src/enums/MilitaryType";
import { ExperimentalPlane } from "../src/models/planes/ExperimentalPlane";
import { MilitaryPlane } from "../src/models/planes/MilitaryPlane";
import { PassengerPlane } from "../src/models/planes/PassengerPlane";

describe("Test functionality of Airport application", () => {
  const planes = [
    new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
    new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
    new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
    new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
    new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
    new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
    new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
    new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
    new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
    new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
    new MilitaryPlane(
      "B-52 Stratofortress",
      1000,
      20000,
      80000,
      MilitaryType.BOMBER
    ),
    new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
    new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
    new MilitaryPlane(
      "C-130 Hercules",
      650,
      5000,
      110000,
      MilitaryType.TRANSPORT
    ),
    new ExperimentalPlane(
      "Bell X-14",
      277,
      482,
      500,
      ExperimentalType.HIGH_ALTITUDE,
      ClassificationLevel.SECRET
    ),
    new ExperimentalPlane(
      "Ryan X-13 Vertijet",
      560,
      307,
      500,
      ExperimentalType.VTOL,
      ClassificationLevel.TOP_SECRET
    ),
  ];
  const planeWithMaxPassengerCapacity = new PassengerPlane(
    "Boeing-747",
    980,
    16100,
    70500,
    242
  );

  it("Should have military planes with transport type", () => {
    const airport = new Airport(planes);
    const transportMilitaryPlanes = airport.getTransportMilitaryPlanes();

    let flag = false;
    for (let militaryPlane of transportMilitaryPlanes) {
      if (militaryPlane.getMilitaryType() === MilitaryType.TRANSPORT) {
        flag = true;
        break;
      }
    }
    assert.equal(flag, true);
  });

  it("Should check passenger plane with max capacity", () => {
    const airport = new Airport(planes);
    const expectedPlaneWithMaxPassengersCapacity =
      airport.getPassengerPlaneWithMaxPassengersCapacity();
    assert.isFalse(
      expectedPlaneWithMaxPassengersCapacity == planeWithMaxPassengerCapacity
    );
  });

  it("Should return passenger plane with max passengers capacity", () => {
    const airport = new Airport(planes);
    const planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity();

    let nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
    for (let i = 0; i < planesSortedByMaxLoadCapacity.length - 1; i++) {
      const currentPlane = planesSortedByMaxLoadCapacity[i];
      const nextPlane = planesSortedByMaxLoadCapacity[i + 1];
      if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
        nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
        break;
      }
    }
    assert.isTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
  });

  it("Should find at least one military plane", () => {
    const airport = new Airport(planes);
    const bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();

    let flag = false;
    for (let militaryPlane of bomberMilitaryPlanes)
      if (militaryPlane.getMilitaryType() === MilitaryType.BOMBER) flag = true;

    assert.isTrue(flag);
  });

  it("Should check that experimentsl planes has classification level higher than unclassified", () => {
    const airport = new Airport(planes);
    const bomberMilitaryPlanes = airport.getExperimentalPlanes();

    let hasUnclassifiedPlanes = false;
    for (let experimentalPlane of bomberMilitaryPlanes) {
      if (
        experimentalPlane.getClassificationLevel() ===
        ClassificationLevel.UNCLASSIFIED
      )
        hasUnclassifiedPlanes = true;

      assert.isFalse(hasUnclassifiedPlanes);
    }
  });
});
