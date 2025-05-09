package za.co.shinysneakers.factory;

import za.co.shinysneakers.domain.Flat;

public class FlatFactory {
    public static Flat createFlat(String unitNumber, String complexName, String streetNumber,
                                  String streetName, String suburb, String city, String postalCode,
                                  int floorNumber) {
        if (unitNumber == null || streetNumber == null || streetName == null ||
                suburb == null || city == null || postalCode == null || floorNumber < 0) {
            return null;
        }

        return new Flat.Builder()
                .unitNumber(unitNumber)
                .complexName(complexName)
                .streetNumber(streetNumber)
                .streetName(streetName)
                .suburb(suburb)
                .city(city)
                .postalCode(postalCode)
                .floorNumber(floorNumber)
                .build();
    }
}
