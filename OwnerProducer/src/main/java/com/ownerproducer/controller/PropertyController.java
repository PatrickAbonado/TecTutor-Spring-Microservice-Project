package com.ownerproducer.controller;


import com.ownerproducer.model.Property;
import com.ownerproducer.model.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-producer")
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;

    @RequestMapping("/all-properties")
    public List<Property> findAllProperties()
    {
        return propertyRepository.findAll();
    }

    @RequestMapping("/insert-property")
    public Property insertOwnerData(@RequestBody Property property)
    {
        propertyRepository.save(property);
        return property;
    }

    @RequestMapping("/property-by-id/{id}")
    public List<Property> findByPropertyId(@PathVariable("id") int propertyId)
    {
        return propertyRepository.findByPropertyId(propertyId);

    }



    @DeleteMapping("/delete-property/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Integer id) {
        try {
            if (!propertyRepository.existsById(id)) {
                return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
            }

            propertyRepository.deleteById(id);

            return new ResponseEntity<>("Property deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete property", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/property-by-address/{propertyAddress}")
    public List<Property> findByPropertyAddress(@PathVariable("propertyAddress") String propertyAddress)
    {
        return propertyRepository.findByPropertyAddress(propertyAddress);

    }

   /*@RequestMapping("/property-by-in/{propertyIn}")
    public List<Property> findByPropertyIn(@PathVariable("propertyIn") String propertyIn){

       return propertyRepository.findByPropertyIn(propertyIn);

    }*/

    @RequestMapping("/property-by-out/{propertyOut}")
    public List<Property> findByPropertyOut(@PathVariable("propertyOut") String propertyIn){

       return propertyRepository.findByPropertyOut(propertyIn);

    }

    @RequestMapping("/property-by-type/{propertyType}")
    public List<Property> findByPropertyType(@PathVariable("propertyType") String propertyType){

        return propertyRepository.findByPropertyType(propertyType);

    }


    @RequestMapping("/property-by-features/{propertyFeatures}")
    public List<Property> findByPropertyFeatures(@PathVariable("propertyFeatures") String propertyFeatures){

        return propertyRepository.findByPropertyFeatures(propertyFeatures);

    }

    @RequestMapping("/property-by-reserved/{propertyReserved}")
    public List<Property> findByPropertyReserved(@PathVariable("propertyReserved") String propertyReserved){

        return propertyRepository.findByPropertyReserved(propertyReserved);

    }

}
