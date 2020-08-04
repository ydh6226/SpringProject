package com.ydh.SpringProject;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


public class Client implements InitializingBean, DisposableBean {
    private String host;

    public void setHost(String host){
        this.host=host;
    }

    @Override
    public void afterPropertiesSet() throws Exception{
        System.out.println("Client.afterPropertiseSet() 실행");
    }

    public void send(){
        System.out.println("Client.send() to "+host);
    }

    @Override
    public void destroy() throws Exception{
        System.out.println("Client.destory() 실행");
    }

}
