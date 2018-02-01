package com.alleyz.k8s.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class JsonResult implements Serializable{
    private boolean success;
    private String msg;
    private Object content;
}
