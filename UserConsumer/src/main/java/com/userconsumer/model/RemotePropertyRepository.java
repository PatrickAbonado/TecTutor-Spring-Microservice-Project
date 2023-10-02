package com.userconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RemotePropertyRepository implements PropertyRepository{
    @Autowired
    protected RestTemplate restTemplate;
    //	@Autowired
    //private DiscoveryClient discoveryClient;
    protected String serviceUrl;
    public RemotePropertyRepository()
    {

    }

    public RemotePropertyRepository(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }


    @Override
    public List<Property> findByPropertyId(int propertyId) {
        System.out.println("Service url is " + serviceUrl);
        Property[] property = restTemplate.getForObject
                (serviceUrl + "/property-by-id/{propertyId}", Property[].class, propertyId);
        return Arrays.asList(property);
    }

    @Override
    public List<Property> findByPropertyAddress(String propertyAddress) {
        System.out.println("Service url is " + serviceUrl);
        Property[] property = restTemplate.getForObject
                (serviceUrl + "/property-by-address/{propertyAddress}", Property[].class, propertyAddress);
        return Arrays.asList(property);
    }


    @Override
    public List<Property> findAllProperties() {
        System.out.println("Service url is " + serviceUrl);
        Property[] allProperties = restTemplate.getForObject
                (serviceUrl + "/all-properties", Property[].class);
        return Arrays.asList(allProperties);
    }

    @Override
    public List<Property> findByPropertyOut(String propertyOut) {
        System.out.println("Service url is " + serviceUrl);
        Property[] property = restTemplate.getForObject
                (serviceUrl + "/property-by-out/{propertyOut}", Property[].class, propertyOut);
        return Arrays.asList(property);
    }

    @Override
    public List<Property> findByPropertyType(String propertyType) {
        System.out.println("Service url is " + serviceUrl);
        Property[] property = restTemplate.getForObject
                (serviceUrl + "/property-by-type/{propertyType}", Property[].class, propertyType);
        return Arrays.asList(property);
    }

    @Override
    public List<Property> findByPropertyFeatures(String propertyFeatures) {
        System.out.println("Service url is " + serviceUrl);
        Property[] property = restTemplate.getForObject
                (serviceUrl + "/property-by-features/{propertyFeatures}", Property[].class, propertyFeatures);
        return Arrays.asList(property);
    }

    @Override
    public List<Property> findByPropertyReserved(String propertyReserved) {
        System.out.println("Service url is " + serviceUrl);
        Property[] property = restTemplate.getForObject
                (serviceUrl + "/property-by-reserved/{propertyReserved}", Property[].class, propertyReserved);
        return Arrays.asList(property);
    }
}
