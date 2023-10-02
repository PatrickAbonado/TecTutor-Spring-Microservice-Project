package com.ownerproducer.controller;

import com.ownerproducer.model.Owner;
import com.ownerproducer.model.OwnerRepository;
import com.ownerproducer.model.User;
import com.ownerproducer.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-producer")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/all-users")
    public List<User> getUserDetails()
    {
        return userRepository.findAll();
    }

    @RequestMapping("/insert-user")
    public User insertUserData(@RequestBody User user)
    {
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/user-by-id/{id}")
    public List<User> findByUserId(@PathVariable("id") int userId)
    {
        return userRepository.findByUserId(userId);

    }

    @RequestMapping("/user-by-name/{name}")
    public List<User> findByUserName(@PathVariable("name") String ownerName)
    {
        return userRepository.findByUserName(ownerName);

    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        try {
            if (!userRepository.existsById(id)) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            userRepository.deleteById(id);

            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
