package com.ownerproducer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    List<Property> findByPropertyId(int propertyId);

    List<Property> findByPropertyAddress(String propertyAddress);
    //List<Property> findByPropertyIn(String propertyIn);
    List<Property> findByPropertyOut(String propertyOut);
    List<Property> findByPropertyType(String propertyType);
    List<Property> findByPropertyFeatures(String propertyFeature);
    List<Property> findByPropertyReserved(String propertyReserved);


}
