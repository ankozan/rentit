package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createTool")
    public ResponseEntity<Tool> createTool(@RequestBody Map<String, String> request) {
        String toolName = request.get("toolName");
        String category = request.get("category");
        String image = request.get("image");
        double rentalPrice = Double.parseDouble(request.get("rentalPrice"));
        String description = request.get("description");
        String email = request.get("email");
        String location = request.get("location");
        Tool tool = new Tool(toolName,category,description,rentalPrice,image,email,location);
        toolService.createTool(tool);
        return new ResponseEntity<Tool>(tool, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Tool>> getAllTools(){
        return new ResponseEntity<List<Tool>>(toolService.getAllTools(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Optional<Tool>> getToolById(@PathVariable String id){
        return new ResponseEntity<Optional<Tool>>(toolService.getToolByToolId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{email}/history")
    public ResponseEntity<List<Optional<Tool>>> getToolsByEmail(@PathVariable String email){
        return new ResponseEntity<List<Optional<Tool>> >(toolService.getToolByEmail(email), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("{id}/availability")
    public ResponseEntity<Tool> updateToolAvailability(@PathVariable String id) {
        toolService.updateAvailabilityToFalse( id);
            return ResponseEntity.ok().build();
    }

}
