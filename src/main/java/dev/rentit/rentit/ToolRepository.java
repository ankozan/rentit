package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolRepository  extends MongoRepository<Tool, ObjectId> {
    @Query("UPDATE tools t SET t.available = :available WHERE t.id = :id")
    int updateAvailabilityById(@Param("id") ObjectId id, @Param("available") Integer available);
}
