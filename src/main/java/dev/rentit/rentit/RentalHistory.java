package dev.rentit.rentit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rental_history")
@Data
@NoArgsConstructor
public class RentalHistory {

    private String renter_name;
    private String rental_date;
    private String return_date;
    private String total_rental_cost;

    public RentalHistory(String renter_name, String rental_date, String return_date, String total_rental_cost) {
        this.renter_name = renter_name;
        this.rental_date = rental_date;
        this.return_date = return_date;
        this.total_rental_cost = total_rental_cost;
    }
}
