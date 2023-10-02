package com.ownerproducer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name="properties")
public class Property {

    @Id
    @GeneratedValue
    private int propertyId;
    private String propertyIn;
    private String propertyOut;
    private String propertyAddress;
    private String propertyType;
    private String propertyFeatures;
    private String propertyRating;
    private String propertyReserved;

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyIn() {
        return propertyIn;
    }

    public void setPropertyIn(String propertyIn) {
        this.propertyIn = propertyIn;
    }

    public String getPropertyOut() {
        return propertyOut;
    }

    public void setPropertyOut(String propertyOut) {
        this.propertyOut = propertyOut;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyLocation) {
        this.propertyAddress = propertyLocation;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyFeatures() {
        return propertyFeatures;
    }

    public void setPropertyFeatures(String propertyFeatures) {
        this.propertyFeatures = propertyFeatures;
    }

    public String getPropertyRating() {
        return propertyRating;
    }

    public void setPropertyRating(String propertyRating) {
        this.propertyRating = propertyRating;
    }

    public String isPropertyReserved() {
        return propertyReserved;
    }

    public void setPropertyReserved(String propertyReserved) {
        this.propertyReserved = propertyReserved;
    }
}
