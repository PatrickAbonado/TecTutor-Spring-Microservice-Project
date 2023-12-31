package com.ownerproducer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByUserId(int userId);

    public List<User> findByUserName(String userName);
}
