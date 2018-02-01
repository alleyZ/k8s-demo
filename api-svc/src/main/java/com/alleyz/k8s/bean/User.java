package com.alleyz.k8s.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter
@ToString
public class User implements Serializable {
    private String userId;
    private String userName;
    private String nickName;
    private String sex;
    private String joinDate;
}
