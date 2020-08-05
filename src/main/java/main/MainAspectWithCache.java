package main;

import chapter7.Calculator;
import config.AppCtxWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppCtxWithCache.class);

        Calculator cal=ctx.getBean("calculator",Calculator.class);

        cal.factorial(6);
        cal.factorial(6);
        cal.factorial(7);
        cal.factorial(7);
        ctx.close();
    }
}
