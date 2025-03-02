package com.dev.todo.service;

import com.dev.todo.model.Users;
import com.dev.todo.repository.UserRepository;
import com.dev.todo.model.UserPrincipal;
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

        Users user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User no found");
        }

        return new UserPrincipal(user);
    }
}
