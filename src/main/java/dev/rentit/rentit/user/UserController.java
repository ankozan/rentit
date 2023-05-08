package dev.rentit.rentit.user;

import dev.rentit.rentit.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired

    private UserService userService;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        User newUser = new User(email,password);
        if(userService.getUser(email) != null){
            userService.createUser(newUser);
            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUser/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return new ResponseEntity<User>(userService.getUser(email), HttpStatus.OK);
    }
    }
