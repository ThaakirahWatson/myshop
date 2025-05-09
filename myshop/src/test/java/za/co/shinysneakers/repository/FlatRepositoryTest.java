package za.co.shinysneakers.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import za.co.shinysneakers.domain.Flat;
import za.co.shinysneakers.factory.FlatFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlatRepositoryTest {

    @Autowired
    private FlatRepository flatRepository;

    private final Flat flat = FlatFactory.createFlat(
            "9C", "Skyview Towers", "88", "Baker Street",
            "Melville", "Johannesburg", "2092", 5
    );

    @Test
    @Order(1)
    @Rollback(false)
    public void saveFlat() {
        Flat saved = flatRepository.save(flat);
        assertNotNull(saved);
        assertNotNull(saved.getAddressId());
    }

    @Test
    @Order(2)
    public void findFlatById() {
        Optional<Flat> found = flatRepository.findById(flat.getAddressId());
        assertTrue(found.isPresent());
        assertEquals("Johannesburg", found.get().getCity());
    }

    @Test
    @Order(3)
    public void getAllFlats() {
        List<Flat> all = flatRepository.findAll();
        assertFalse(all.isEmpty());
    }

    @Test
    @Order(4)
    public void testCustomQuery() {
        List<Flat> results = flatRepository.findFlatsAboveFloor(3);
        assertFalse(results.isEmpty());
    }

    @Test
    @Order(5)
    @Rollback(false)
    public void deleteFlat() {
        flatRepository.deleteById(flat.getAddressId());
        Optional<Flat> deleted = flatRepository.findById(flat.getAddressId());
        assertFalse(deleted.isPresent());
    }
}
