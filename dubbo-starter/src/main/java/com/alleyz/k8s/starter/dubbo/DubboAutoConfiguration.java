package com.alleyz.k8s.starter.dubbo;

import com.alibaba.dubbo.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhaihw on 2017/7/7.
 * 自动配置
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class DubboAutoConfiguration {
    @Autowired
    private DubboProperties dubboProperties;

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = dubboProperties.getApplication();
        return applicationConfig == null ? new ApplicationConfig() : applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = dubboProperties.getRegistry();
        return registryConfig != null ? registryConfig : new RegistryConfig();
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = dubboProperties.getProtocol();
        return protocolConfig != null ? protocolConfig : new ProtocolConfig();
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = dubboProperties.getMonitor();
        return monitorConfig != null ? monitorConfig : new MonitorConfig();
    }

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = dubboProperties.getProvider();
        return providerConfig != null ? providerConfig : new ProviderConfig();
    }

    @Bean
    public ModuleConfig moduleConfig() {
        ModuleConfig moduleConfig = dubboProperties.getModule();
        return moduleConfig != null ? moduleConfig : new ModuleConfig();
    }

    @Bean
    public MethodConfig methodConfig() {
        MethodConfig methodConfig = dubboProperties.getMethod();
        return methodConfig != null ? methodConfig : new MethodConfig();
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = dubboProperties.getConsumer();
        return consumerConfig != null ? consumerConfig : new ConsumerConfig();
    }
}
