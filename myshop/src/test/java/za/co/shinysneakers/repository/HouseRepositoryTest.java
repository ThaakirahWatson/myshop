package za.co.shinysneakers.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import za.co.shinysneakers.domain.House;
import za.co.shinysneakers.factory.HouseFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HouseRepositoryTest {

    @Autowired
    private HouseRepository houseRepository;

    private final House house = HouseFactory.createHouse(
            "7", "Palm Grove", "123", "Maple Street",
            "Newlands", "Cape Town", "7700", 750.0
    );

    @Test
    @Order(1)
    @Rollback(false)
    public void saveHouse() {
        House saved = houseRepository.save(house);
        assertNotNull(saved);
        assertNotNull(saved.getAddressId());
    }

    @Test
    @Order(2)
    public void findHouseById() {
        Optional<House> found = houseRepository.findById(house.getAddressId());
        assertTrue(found.isPresent());
        assertEquals("Cape Town", found.get().getCity());
    }

    @Test
    @Order(3)
    public void getAllHouses() {
        List<House> all = houseRepository.findAll();
        assertFalse(all.isEmpty());
    }

    @Test
    @Order(4)
    public void testCustomQuery() {
        List<House> results = houseRepository.findHousesWithErfSizeGreaterThan(500);
        assertFalse(results.isEmpty());
    }

    @Test
    @Order(5)
    @Rollback(false)
    public void deleteHouse() {
        houseRepository.deleteById(house.getAddressId());
        Optional<House> deleted = houseRepository.findById(house.getAddressId());
        assertFalse(deleted.isPresent());
    }
}
