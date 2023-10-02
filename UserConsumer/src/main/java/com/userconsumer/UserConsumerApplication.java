package com.userconsumer;

import com.userconsumer.model.PropertyRepository;
import com.userconsumer.model.RemotePropertyRepository;
import com.userconsumer.model.RemoteUserRepository;
import com.userconsumer.model.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserConsumerApplication {

    public static final String	Property_SERVICE_URL = "http://localhost:1760/property-producer";
    public static final String	User_SERVICE_URL = "http://localhost:1760/user-producer";
    public static final String url="https://gorest.co.in/public/v2/users/657";

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }

    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();//RestTemplate is a predefined class
        //which can be used to access any microservice
    }

    @Bean(name="b1")
    public PropertyRepository propertyRepository(){
        return new RemotePropertyRepository(Property_SERVICE_URL);
    }

    @Bean(name="b2")
    public UserRepository userRepository(){
        return new RemoteUserRepository(User_SERVICE_URL);
    }

}

