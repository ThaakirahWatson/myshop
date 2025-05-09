package za.co.shinysneakers.factory;

import org.junit.jupiter.api.Test;
import za.co.shinysneakers.domain.House;

import static org.junit.jupiter.api.Assertions.*;

public class HouseFactoryTest {

    @Test
    public void testCreateHouseSuccess() {
        House house = HouseFactory.createHouse("12A", "Palm Grove", "34", "Oak Street",
                "Suburbia", "Cape Town", "8000", 800);
        assertNotNull(house);
        assertEquals("Cape Town", house.getCity());
    }

    @Test
    public void testCreateHouseFailure() {
        House house = HouseFactory.createHouse(null, null, "34", "Oak Street",
                "Suburbia", "Cape Town", "8000", -50);
        assertNull(house);
    }
}
