package com.alleyz.k8s.api;

import com.alleyz.k8s.bean.SysUser;

import java.util.List;

public interface ISysUser {
    public List<SysUser> findAll();
}
