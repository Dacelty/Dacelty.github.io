package com.example.btspringsecloginlogout.service;

import com.example.btspringsecloginlogout.entity.User;
import com.example.btspringsecloginlogout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username");
        System.out.println(username);
        User user = userRepository.findByTaiKhoan(username);
        System.out.println(user);

        if (user == null) {
            throw new EntityNotFoundException("Username or password not found");
        }

        String password = user.getMatKhau();

        return new org.springframework.security.core.userdetails.User(username, password, Collections.emptyList());
    }
}
