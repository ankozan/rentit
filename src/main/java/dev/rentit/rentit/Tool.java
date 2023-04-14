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
import java.util.Random;

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
    private String toolId;
    @Field("rental_history")
    private List<Object> rental_history;
    private String rating;
    private String email;
    private String location;

    public Tool(String toolName,String category, String description, double rentalPrice, String image,String email,String location){
        tool_name = toolName;
        this.category = category;
        this.description = description;
        this.rental_price = rentalPrice;
        this.image = image;
        available = true;
        toolId = String.valueOf(new Random().nextInt(1000));
        rating = "5.0";
        this.email = email;
        this.location = location;
    }
}
