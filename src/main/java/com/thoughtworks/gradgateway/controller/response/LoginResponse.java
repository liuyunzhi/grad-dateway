package com.thoughtworks.gradgateway.controller.response;

import com.thoughtworks.gradgateway.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String token;

    public LoginResponse(Users user) {
        if (user != null) {
            this.token = "bGl1eXVuemhpOjEyMzQ1Ng==";
        } else {
            this.token = "";
        }
    }
}
