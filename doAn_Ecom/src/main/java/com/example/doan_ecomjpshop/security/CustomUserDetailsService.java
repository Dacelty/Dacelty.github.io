package com.example.doan_ecomjpshop.security;

import com.example.doan_ecomjpshop.entity.Manager;
import com.example.doan_ecomjpshop.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ManagerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Manager> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Not found user with email = " + email);
        }

        return new CustomUserDetails(userOptional.get());
    }
}
