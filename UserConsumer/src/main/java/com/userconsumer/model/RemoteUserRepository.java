package com.userconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RemoteUserRepository implements UserRepository{

    @Autowired
    protected RestTemplate restTemplate;
    //	@Autowired
    //private DiscoveryClient discoveryClient;
    protected String serviceUrl;
    public RemoteUserRepository()
    {

    }

    public RemoteUserRepository(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    @Override
    public List<User> findByUserId(int userId) {
        System.out.println("Service url is " + serviceUrl);
        User[] user = restTemplate.getForObject
                (serviceUrl + "/user-by-id/{id}", User[].class, userId);
        return Arrays.asList(user);
    }

    @Override
    public List<User> findByUserName(String userName) {
        System.out.println("Service url is " + serviceUrl);
        User[] user = restTemplate.getForObject
                (serviceUrl + "/user-by-name/{name}", User[].class, userName);
        return Arrays.asList(user);
    }


}
