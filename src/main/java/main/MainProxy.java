package main;

import chapter7.ExeTimeCalculator;
import chapter7.ImpleCalculator;
import chapter7.RecCalculator;

public class MainProxy {
    public static void main(String[] args){
        ExeTimeCalculator ttCal1=new ExeTimeCalculator(new ImpleCalculator());
        System.out.println(ttCal1.factorial(20));

        ExeTimeCalculator ttCal2=new ExeTimeCalculator(new RecCalculator());
        System.out.println(ttCal2.factorial(20));
    }
}
