package com.plangenerator.ism.Service;


import com.plangenerator.ism.Model.User;

public interface UserService {


    User findByUsername(String username);



    void save(User user);


}
