package com.example.myfirstfullstackwebsite.services;

import com.example.myfirstfullstackwebsite.details.MyUserDetails;
import com.example.myfirstfullstackwebsite.entities.MyUser;
import com.example.myfirstfullstackwebsite.repositories.MyUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MyUserRepository userRepository;

    public MyUserDetailsService(MyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> oMyUser = userRepository
                .findOneByUsername(username);

        return new MyUserDetails(oMyUser
                .orElseThrow(
                        () -> new UsernameNotFoundException("This user not found")
                )
        );
    }
}

