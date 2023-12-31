package com.ownerproducer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository <Owner, Integer>{

    public Owner findByOwnerId(int ownerId);

    public Owner findByOwnerName(String ownerName);
}
