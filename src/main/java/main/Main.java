package main;

import com.ydh.SpringProject.Client;
import config.AppCtx6;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException{
        AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppCtx6.class);

        Client client=ctx.getBean(Client.class);
        client.send();

        ctx.close();
    }
}
