package com.plangenerator.ism.Service;


import com.plangenerator.ism.Model.Role;
import com.plangenerator.ism.Model.User;
import com.plangenerator.ism.Repository.RoleRepository;
import com.plangenerator.ism.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public boolean isEsist(String username) {

        return userRepository.findByUsername(username) != null;


    }

    public int countUser() {
        return userRepository.findAll().size();
    }

}
