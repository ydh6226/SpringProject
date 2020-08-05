package main;

import chapter7.Calculator;
import chapter7.RecCalculator;
import config.AppCtx7;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx7.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        long fiveFact = cal.factorial(5);

        System.out.println("cal.factorial(5) = "+fiveFact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }

}
