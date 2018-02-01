package com.alleyz.k8s.starter.dubbo;

import com.alibaba.dubbo.config.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zhaihw on 2017/7/7.
 * dubbo properties
 */
@ConfigurationProperties(prefix = "spring.dubbo")
@Data
public class DubboProperties {
    private String scan;
    private ApplicationConfig application;
    private RegistryConfig registry;
    private ProtocolConfig protocol;
    private MonitorConfig monitor;
    private ProviderConfig provider;
    private ModuleConfig module;
    private MethodConfig method;
    private ConsumerConfig consumer;

}
