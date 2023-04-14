package dev.rentit.rentit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface RentalRepository extends MongoRepository<Rental, String> {
    Optional<Rental> findByToolId(String toolId);
    List<Optional<Rental>> findByUser(String Email);

}
