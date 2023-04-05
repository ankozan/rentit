package dev.rentit.rentit;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping
    public ResponseEntity<List<Tool>> getAllTools(){
        return new ResponseEntity<List<Tool>>(toolService.getAllTools(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Tool>> getToolById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Tool>>(toolService.getToolById(id), HttpStatus.OK);
    }
}
