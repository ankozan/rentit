package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToolRepository  extends MongoRepository<Tool, ObjectId> {
    Optional<Tool> findByToolId(String toolId);
    List<Optional<Tool>> findByEmail(String Email);

}
