package za.co.shinysneakers.factory;

import za.co.shinysneakers.domain.House;

public class HouseFactory {
    public static House createHouse(String unitNumber, String complexName, String streetNumber,
                                    String streetName, String suburb, String city, String postalCode,
                                    double erfSize) {
        if (unitNumber == null || streetNumber == null || streetName == null ||
                suburb == null || city == null || postalCode == null || erfSize <= 0) {
            return null;
        }

        return new House.Builder()
                .unitNumber(unitNumber)
                .complexName(complexName)
                .streetNumber(streetNumber)
                .streetName(streetName)
                .suburb(suburb)
                .city(city)
                .postalCode(postalCode)
                .erfSize(erfSize)
                .build();
    }
}
