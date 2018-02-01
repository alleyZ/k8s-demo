package com.alleyz.k8s.web.rest;

import com.alleyz.k8s.api.ISysUser;
import com.alleyz.k8s.bean.JsonResult;
import com.alleyz.k8s.bean.SysUser;
import com.alleyz.k8s.bean.User;
import com.alleyz.k8s.web.service.SysUserServiceImpl;
import com.alleyz.k8s.web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRest {

    @Autowired
    private UserServiceImpl userService;


    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping("/findAll.al")
    public JsonResult findAll() {
        JsonResult json = new JsonResult();
        try {
            json.setSuccess(true);
            json.setContent(sysUserService.findAll());
        }catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }
}
