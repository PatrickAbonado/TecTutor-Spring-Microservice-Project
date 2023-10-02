package com.userconsumer.model;

import java.util.List;

public interface UserRepository {
    public List<User> findByUserId(int userId);
    public List<User> findByUserName(String userName);

}
