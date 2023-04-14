package dev.rentit.rentit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RentalService {
    private static final String RENTAL_STATUS_ENDED = "ENDED";
    private static final String RENTAL_STATUS_RENTED = "RENTED";

    @Autowired
    private RentalRepository rentalRepository;

    public List<Optional<Rental>> getRentalByUser(String email) {
        return rentalRepository.findByUser(email);
    }
    public Rental createRental(String startDate, String endDate, String toolId, String user) {
        Rental rental = new Rental(startDate, endDate, toolId, user, RENTAL_STATUS_RENTED);
        return rentalRepository.save(rental);
    }

    public Rental endRental(String toolId) {
        Optional<Rental> rental = rentalRepository.findByToolId(toolId);
        if (rental == null) {
            // Rental not found
            return null;
        }
        rental.get().setStatus(RENTAL_STATUS_ENDED);
        return rentalRepository.save(rental.get());
    }
}
