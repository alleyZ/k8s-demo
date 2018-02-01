package com.alleyz.k8s.starter.dubbo;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Created by zhaihw on 2017/7/7.
 * 初始化
 */
public class DubboConfigInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

    private final static String SCAN_PKG = "spring.dubbo.scan";
    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        Environment env = ctx.getEnvironment();
        String pkg = env.getProperty(SCAN_PKG);
        if(pkg != null) {
            AnnotationBean scanner = BeanUtils.instantiate(AnnotationBean.class);
            scanner.setPackage(pkg);
            scanner.setApplicationContext(ctx);
            ctx.addBeanFactoryPostProcessor(scanner);
            ctx.getBeanFactory().addBeanPostProcessor(scanner);
            ctx.getBeanFactory().registerSingleton("dubboAnnBean", scanner);
        }
    }
}
