package com.plangenerator.ism.Service;


import com.plangenerator.ism.Model.User;
import com.plangenerator.ism.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CostumeUserDetails extends User implements UserDetails {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    CostumeUserDetailService costumeUserDetailService;


    public CostumeUserDetails(final User users) {
        super(users);

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return getRoles().stream().
                map(role -> new SimpleGrantedAuthority(role.getName())).
                collect(Collectors.toList());




    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
