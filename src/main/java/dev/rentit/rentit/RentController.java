package dev.rentit.rentit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tools")
public class RentController {


    @Autowired
    private  RentalService rentalService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/rentals")
    public ResponseEntity<List<Optional<Rental>>> getRentalByUser(@RequestParam String email) {
        List<Optional<Rental>> rentals = rentalService.getRentalByUser(email);
        return ResponseEntity.ok(rentals);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{id}/start")
    public ResponseEntity<Rental> createRental(@RequestParam String startDate, @RequestParam String endDate, @RequestParam String toolId, @RequestParam  String user) {
        Rental createdRental = rentalService.createRental(startDate,endDate,toolId,user);
        return ResponseEntity.ok(createdRental);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}/end")
    public ResponseEntity<Rental> endRental(@PathVariable("id") String toolId) {
        Rental createdRental = rentalService.endRental(toolId);
        return ResponseEntity.ok(createdRental);
    }
}
