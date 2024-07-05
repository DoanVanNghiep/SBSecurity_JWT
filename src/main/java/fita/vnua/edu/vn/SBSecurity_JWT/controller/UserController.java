package fita.vnua.edu.vn.SBSecurity_JWT.controller;

import fita.vnua.edu.vn.SBSecurity_JWT.dto.request.UserCreationRequest;
import fita.vnua.edu.vn.SBSecurity_JWT.dto.request.UserUpdateRequest;
import fita.vnua.edu.vn.SBSecurity_JWT.entity.User;
import fita.vnua.edu.vn.SBSecurity_JWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUser(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable Integer id,
                    @RequestBody UserUpdateRequest request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Integer id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User has been delete!.");
        } catch (RuntimeException e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist!. ");
        }
    }
}
