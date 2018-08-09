package com.thoughtworks.gradgateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private Long id;
    private String username;
    private String password;
    private Authority authority;
}
