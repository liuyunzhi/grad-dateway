package com.thoughtworks.gradgateway.service;

import com.thoughtworks.gradgateway.controller.request.UserRequest;
import com.thoughtworks.gradgateway.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.security.crypto.bcrypt.BCrypt.checkpw;

@Service
public class UsersService {

    private final String URL = "http://localhost:8083/users/{username}";

    public Users get(String username) {
        return new RestTemplate().getForObject(URL, Users.class, username);
    }

    public Users validate(UserRequest userRequest) {
        Users user = get(userRequest.getUsername());

        if (!checkpw(userRequest.getPassword(),user.getPassword())) {
            return null;
        }

        return user;
    }
}
