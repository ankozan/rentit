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

    public void createTool(Tool tool) {
        toolRepository.save(tool);
    }

    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    public Optional<Tool> getToolByToolId(String id) {
        return toolRepository.findByToolId(id);
    }

    public List<Optional<Tool>> getToolByEmail(String email) {
        return toolRepository.findByEmail(email);
    }
    public void updateAvailabilityToFalse(String toolId) {
        Optional<Tool> optionalTool = toolRepository.findByToolId(toolId);
        if (optionalTool.isPresent()) {
            Tool tool = optionalTool.get();
            tool.setAvailable(false);
            toolRepository.save(tool);
        }
    }
}