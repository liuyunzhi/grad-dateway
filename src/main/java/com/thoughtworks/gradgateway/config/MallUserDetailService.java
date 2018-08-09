package com.thoughtworks.gradgateway.config;

import com.thoughtworks.gradgateway.model.Users;
import com.thoughtworks.gradgateway.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MallUserDetailService implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersService.get(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s dosen't exist!", username));
        } else {
            return new JwtUserDetails(user);
        }
    }
}
