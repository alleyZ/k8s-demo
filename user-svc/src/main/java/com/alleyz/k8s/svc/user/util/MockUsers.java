package com.alleyz.k8s.svc.user.util;

import com.alleyz.k8s.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockUsers {

    private static Map<String, User> mockUserMap = new HashMap<>();

    static {

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserId(i + "");
            user.setUserName("UserName" + i);
            user.setNickName("NickName" + i);
            user.setSex(i % 2 + "");
            mockUserMap.put("UserName" + i, user);
        }

    }

    public static User getUser(String userName) {
        return mockUserMap.get(userName);
    }

    public static List<User> getUserList() {
        List<User> list = new ArrayList<>();
        mockUserMap.forEach((k, v) -> list.add(v));
        return list;
    }

}
