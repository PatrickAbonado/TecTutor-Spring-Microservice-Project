package com.userconsumer.model;

import java.util.List;

public interface PropertyRepository {

    public List<Property> findByPropertyId(int propertyId);
    public List<Property> findByPropertyAddress(String propertyAddress);
    public List<Property> findAllProperties();

    public List<Property> findByPropertyOut(String propertyOut);

    public List<Property> findByPropertyType(String propertyType);
    public List<Property> findByPropertyFeatures(String propertyFeatures);
    public List<Property> findByPropertyReserved(String propertyReserved);


}
