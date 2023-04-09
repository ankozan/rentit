package dev.rentit.rentit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RentalRepository extends MongoRepository<Rental, String> {
    Rental findByToolId(String toolId);
}
