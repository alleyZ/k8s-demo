package com.alleyz.k8s.web.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alleyz.k8s.api.ISysUser;
import com.alleyz.k8s.bean.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl {

    @Reference(version = "10")
    private ISysUser iSysUser;

    public List<SysUser> findAll(){
        return iSysUser.findAll();
    }
}
