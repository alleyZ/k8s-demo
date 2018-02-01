package com.alleyz.k8s.svc.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alleyz.k8s.api.IUser;
import com.alleyz.k8s.bean.User;
import com.alleyz.k8s.svc.user.util.MockUsers;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Service(version = "10")
@Log4j
public class UserSvcImpl implements IUser{

    @Override
    public User findById(String userId) {

        return MockUsers.getUser(userId);
    }

    @Override
    public String check(String userName, String password) {
        log.info("userName" + userName);
        User user = MockUsers.getUser(userName);
        return user == null ? null : userName;
    }

    @Override
    public List<User> findByName(String userName) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return MockUsers.getUserList();
    }
}
