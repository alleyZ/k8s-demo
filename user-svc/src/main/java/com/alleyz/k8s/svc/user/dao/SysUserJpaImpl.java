package com.alleyz.k8s.svc.user.dao;

import com.alleyz.k8s.svc.user.bean.TblSysUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserJpaImpl extends JpaRepository<TblSysUsers, String> {
}
