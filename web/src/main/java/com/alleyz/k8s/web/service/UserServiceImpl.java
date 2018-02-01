package com.alleyz.k8s.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alleyz.k8s.api.IUser;
import com.alleyz.k8s.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Reference(version = "10")
    private IUser iUser;

    public User find(String userName, String password) {
        String id = iUser.check(userName, password);
        if(id == null) return null;
        return iUser.findById(id);
    }

    public List<User> findAll() {
        return iUser.findAll();
    }
}
