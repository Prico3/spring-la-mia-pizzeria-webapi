package org.lessons.java.pizzeria.security;

import org.lessons.java.pizzeria.model.User;
import org.lessons.java.pizzeria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //recupero lo user dal db a partire dall'email
        Optional<User> user = userRepository.findByEmail(username);
        if ((user.isPresent())) {
            // creo un oggetto userdetails a partire da quello user
            return new DatabaseUserDetails(user.get());

        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
