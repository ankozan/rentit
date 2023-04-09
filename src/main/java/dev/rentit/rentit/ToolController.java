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
    @GetMapping
    public ResponseEntity<List<Tool>> getAllTools(){
        return new ResponseEntity<List<Tool>>(toolService.getAllTools(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Optional<Tool>> getToolById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Tool>>(toolService.getToolById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("{id}/availability")
    public ResponseEntity<Tool> updateToolAvailability(@PathVariable String id) {
        toolService.updateAvailabilityToFalse( id);
            return ResponseEntity.ok().build();
    }
}
