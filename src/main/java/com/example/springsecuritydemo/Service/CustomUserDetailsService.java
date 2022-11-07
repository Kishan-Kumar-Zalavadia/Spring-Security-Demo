package com.example.springsecuritydemo.Service;

import com.example.springsecuritydemo.CustomUserDetails;
import com.example.springsecuritydemo.Model.User;
import com.example.springsecuritydemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null)
            throw  new UsernameNotFoundException("User not found!!");
        return new CustomUserDetails(user);
    }
}
