package com.alleyz.k8s.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable{

    private String userCode; // 用户账号

    private String userName; // 用户姓名

    private String agentName; // 坐席姓名 昵称

    private String userNo; // 用户内部编号

    private String userType; // 用户类型(通用编码表中关联USER_TYPE 0系统内置，1开发人员，2客户职员)

    private String orgId; // 机构ID(IS_ORG=1的)
}
