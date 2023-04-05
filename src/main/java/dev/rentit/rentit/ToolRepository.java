package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository  extends MongoRepository<Tool, ObjectId> {
}
