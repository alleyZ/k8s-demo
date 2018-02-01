package com.alleyz.k8s.api;


import com.alleyz.k8s.bean.User;

import java.util.List;

public interface IUser {


    public User findById(String userId);

    public String check(String userName, String password);

    public List<User> findByName(String userName);

    public List<User> findAll();

}
