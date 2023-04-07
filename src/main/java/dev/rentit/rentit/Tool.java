package dev.rentit.rentit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "tools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tool {
    @Id
    private ObjectId id;
    private String tool_name;
    private String category;
    private String description;
    private double rental_price;
    private boolean available;
    private String image;

    @Field("rental_history")
    private List<Object> rental_history;

}
