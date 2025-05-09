package za.co.shinysneakers.factory;

import org.junit.jupiter.api.Test;
import za.co.shinysneakers.domain.Flat;

import static org.junit.jupiter.api.Assertions.*;

public class FlatFactoryTest {

    @Test
    public void testCreateFlatSuccess() {
        Flat flat = FlatFactory.createFlat("3B", "Sky Heights", "45", "Main Road",
                "Central", "Johannesburg", "2000", 5);
        assertNotNull(flat);
        assertEquals(5, flat.getFloorNumber());
    }

    @Test
    public void testCreateFlatFailure() {
        Flat flat = FlatFactory.createFlat("3B", null, "45", "Main Road",
                "Central", "Johannesburg", "2000", -1);
        assertNull(flat);
    }
}
