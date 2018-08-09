package com.thoughtworks.gradgateway.controller;

import com.thoughtworks.gradgateway.controller.request.UserRequest;
import com.thoughtworks.gradgateway.controller.response.LoginResponse;
import com.thoughtworks.gradgateway.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ResponseEntity login(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(new LoginResponse(usersService.validate(userRequest)));
    }
}
