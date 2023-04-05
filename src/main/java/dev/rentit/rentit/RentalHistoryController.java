package dev.rentit.rentit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/rentalhistories")
public class RentalHistoryController {
    @Autowired
    private  RentalHistoryService rentalHistoryService;

    @PostMapping
    public ResponseEntity<RentalHistory> createHistory(@RequestBody Map<String,String> payload){
        return new ResponseEntity<RentalHistory>(rentalHistoryService.createNewHistory(payload.get("id"),payload.get("renterName"),payload.get("rentalDate"),payload.get("returnDate"),payload.get("totalRentalCost")), HttpStatus.CREATED);
    }
}
