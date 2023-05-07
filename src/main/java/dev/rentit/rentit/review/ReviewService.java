package dev.rentit.rentit.review;

import dev.rentit.rentit.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsById(String id){
        return reviewRepository.findByToolId(id);
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

}
