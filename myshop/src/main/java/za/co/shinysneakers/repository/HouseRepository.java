package za.co.shinysneakers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.shinysneakers.domain.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    // Custom finder methods (optional)
    List<House> findByCity(String city);
    List<House> findBySuburb(String suburb);

    // JPQL Example: Houses with erfSize greater than specified
    @Query("SELECT h FROM House h WHERE h.erfSize > :size")
    List<House> findHousesWithErfSizeGreaterThan(double size);
}
