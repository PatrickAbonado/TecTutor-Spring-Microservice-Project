package com.ownerproducer.controller;

import com.ownerproducer.model.Owner;
import com.ownerproducer.model.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner-producer")
public class OwnerController {

    @Autowired
    OwnerRepository ownerRepository;

    @RequestMapping("/all-owners")
    public List<Owner> getOwnerDetails()
    {
        return ownerRepository.findAll();
    }

    @RequestMapping("/insert-owner")
    public Owner insertOwnerData(@RequestBody Owner owner)
    {
        ownerRepository.save(owner);
        return owner;
    }

    @RequestMapping("/owner-by-id/{id}")
    public Owner findByOwnerId(@PathVariable("id") int ownerId)
    {
        return ownerRepository.findByOwnerId(ownerId);

    }

    @RequestMapping("/owner-by-name/{name}")
    public Owner findByOwnerName(@PathVariable("name") String ownerName)
    {
        return ownerRepository.findByOwnerName(ownerName);

    }

    @DeleteMapping("/delete-owner/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Integer id) {
        try {
            if (!ownerRepository.existsById(id)) {
                return new ResponseEntity<>("Owner not found", HttpStatus.NOT_FOUND);
            }

            ownerRepository.deleteById(id);

            return new ResponseEntity<>("Owner deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete owner", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
