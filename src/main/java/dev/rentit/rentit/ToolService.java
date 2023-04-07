package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    public Optional<Tool> getToolById(ObjectId id) {
        return toolRepository.findById(id);
    }

    public void updateAvailabilityToFalse(ObjectId id) {
        Optional<Tool> optionalTool = toolRepository.findById(id);
        if (optionalTool.isPresent()) {
            Tool tool = optionalTool.get();
            tool.setAvailable(false);
            toolRepository.save(tool);
        }
    }
}