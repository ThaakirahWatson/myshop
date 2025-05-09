package za.co.shinysneakers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.shinysneakers.domain.Flat;

import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

    // Custom finder methods (optional)
    List<Flat> findByCity(String city);
    List<Flat> findBySuburb(String suburb);

    // JPQL Example: Flats above a certain floor
    @Query("SELECT f FROM Flat f WHERE f.floorNumber > :floor")
    List<Flat> findFlatsAboveFloor(int floor);
}
