package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class RentalHistoryService {
    @Autowired
    private RentalHistoryRepository rentalHistoryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public RentalHistory createNewHistory(String id, String renterName, String rentalDate, String returnDate, String totalRentalCost){
        RentalHistory rentalHistory = new RentalHistory(renterName, rentalDate, returnDate, totalRentalCost);
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().addToSet("rental_history", rentalHistory);
        mongoTemplate.updateFirst(query, update, Tool.class);
        return rentalHistory;
    }
}
