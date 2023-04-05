package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;
    public List<Tool> getAllTools(){
        return toolRepository.findAll();
    }

    public Optional<Tool> getToolById(ObjectId id){
        return toolRepository.findById(id);
    }
}
