package dev.rentit.rentit.review;

import dev.rentit.rentit.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService  reviewService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<List<Review>> getReviewsById(@PathVariable String id){
        return new ResponseEntity<List<Review> >(reviewService.getReviewsById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Review>> getAllTools(){
        return new ResponseEntity<List<Review>>(reviewService.getAllReviews(), HttpStatus.OK);
    }
}
