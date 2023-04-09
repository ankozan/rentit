package dev.rentit.rentit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rentals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {


    @Id
    private String id;

    private String startDate;

    private String endDate;

    private String toolId;

    private String user;

    private String status;

    public Rental(String startDate, String endDate, String toolId, String user, String status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.toolId = toolId;
        this.user = user;
        this.status = status;
    }

}
