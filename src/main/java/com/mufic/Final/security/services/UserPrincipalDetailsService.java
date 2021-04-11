package com.mufic.Final.security.services;

import com.mufic.Final.domain.User;
import com.mufic.Final.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//        User user = userRepository.findByUsername(s)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", s)));
        Optional<User> byUsername = userRepository.findByUsername(s);
        Optional<User>  byEmail= userRepository.findByEmail(s);

        if(byUsername.isPresent()){
            return new UserPrincipal(byUsername.get());
        }else if (byEmail.isPresent()){
            return new UserPrincipal(byEmail.get());
        }

        throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", s));
    }
}
