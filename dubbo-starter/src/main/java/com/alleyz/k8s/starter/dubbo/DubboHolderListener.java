package com.alleyz.k8s.starter.dubbo;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Created by zhaihw on 2017/7/7.
 *
 */
public class DubboHolderListener implements ApplicationListener{
    private static Thread holdThread;
    private static Boolean running = Boolean.FALSE;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationPreparedEvent) {
            if (running == Boolean.FALSE)
                running = Boolean.TRUE;
            if (holdThread == null) {
                holdThread = new Thread(()-> {
                    while (running && !Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                    }
                }, "Dubbo-Holder");
                holdThread.setDaemon(false);
                holdThread.start();
            }
        }
        if (event instanceof ContextClosedEvent) {
            running = Boolean.FALSE;
            if (null != holdThread) {
                holdThread.interrupt();
                holdThread = null;
            }
        }
    }

    public static void stopApplicationContext(Boolean stop){
        running = stop;
        if (null != holdThread) {
            holdThread.interrupt();
            holdThread = null;
        }
    }
}
