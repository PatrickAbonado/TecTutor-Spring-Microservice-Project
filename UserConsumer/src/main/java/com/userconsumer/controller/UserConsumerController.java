package com.userconsumer.controller;

import com.userconsumer.model.Property;
import com.userconsumer.model.PropertyRepository;
import com.userconsumer.model.User;
import com.userconsumer.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-consumer")
public class UserConsumerController {

    @Autowired
    @Qualifier("b1")
    PropertyRepository propertyRepository;

    @Autowired
    @Qualifier("b2")
    UserRepository userRepository;

    @GetMapping("/all-properties")
    public List<Property> getAllProperties()
    {
        return propertyRepository.findAllProperties();
    }

    @GetMapping("/property-by-id/{id}")
    public List<Property> getByPropertyId(@PathVariable("id")int propertyId)
    {
        return propertyRepository.findByPropertyId(propertyId);

    }

    @GetMapping("/property-by-address/{propertyAddress}")
    public List<Property> getByPropertyAddress(@PathVariable("propertyAddress")String propertyAddress)
    {
        return propertyRepository.findByPropertyAddress(propertyAddress);

    }

    @GetMapping("/user-by-id/{id}")
    public List<User> getByUserId(@PathVariable("id")int userId)
    {
        return userRepository.findByUserId(userId);

    }

    @GetMapping("/user-by-name/{name}")
    public List<User> getByUserName(@PathVariable("name")String userName)
    {
        return userRepository.findByUserName(userName);

    }


    @GetMapping("/property-by-out/{propertyOut}")
    public List<Property> getByPropertyOut(@PathVariable("propertyOut")String propertyOut)
    {
        return propertyRepository.findByPropertyOut(propertyOut);

    }

    @GetMapping("/property-by-type/{propertyType}")
    public List<Property> getByPropertyType(@PathVariable("propertyType")String propertyOut)
    {
        return propertyRepository.findByPropertyType(propertyOut);

    }

    @GetMapping("/property-by-features/{propertyFeatures}")
    public List<Property> getByPropertyFeatures(@PathVariable("propertyFeatures")String propertyFeatures)
    {
        return propertyRepository.findByPropertyFeatures(propertyFeatures);

    }

    @GetMapping("/property-by-reserved/{propertyReserved}")
    public List<Property> getByPropertyReserved(@PathVariable("propertyReserved")String propertyReserved)
    {
        return propertyRepository.findByPropertyReserved(propertyReserved);

    }


}
