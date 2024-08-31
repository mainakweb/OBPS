package com.example.jwt.security;


import com.example.jwt.model.Auth;
import com.example.jwt.model.User;
import com.example.jwt.repository.AuthRepository;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthRepository authRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
System.out.println("%^&*(*&^%$");
        //System.out.println(user.getPassword());
       List<Auth> auth = authRepository.findByVendorCode(username);
//       System.out.println(auth.get(0).getUsername());
//        System.out.println(auth.get(0).getPassword());
     //  return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

      return new org.springframework.security.core.userdetails.User(auth.get(0).getUsername(), auth.get(0).getPassword(), new ArrayList<>());
    }


}

