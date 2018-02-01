package com.alleyz.k8s.svc.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alleyz.k8s.api.ISysUser;
import com.alleyz.k8s.bean.SysUser;
import com.alleyz.k8s.svc.user.bean.TblSysUsers;
import com.alleyz.k8s.svc.user.dao.SysUserJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service(version = "10")
public class SysUserSvcImpl implements ISysUser{

    @Autowired
    private SysUserJpaImpl userJpa;

    @Override
    public List<SysUser> findAll() {
        List<TblSysUsers> sysUsers = userJpa.findAll();
        List<SysUser> users = new ArrayList<>();
        sysUsers.forEach(u -> {
            SysUser sysUser = new SysUser();
            sysUser.setAgentName(u.getAgentName());
            sysUser.setOrgId(u.getOrgId());
            sysUser.setUserCode(u.getUserCode());
            sysUser.setUserNo(u.getUserNo());
            sysUser.setUserType(u.getUserType());
            users.add(sysUser);
        });

        return users;
    }


}
