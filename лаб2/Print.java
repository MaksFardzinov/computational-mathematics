package com.лаб2;

public class Print {
    public static void print_for_method_hord(double answer,double b){
        if(answer==b+1){
            System.out.println("f(a)*f(b)>=0");
        }
        else {
            System.out.println("Метод хорд");
            System.out.println("x = "+answer);
        }
    }
    public static void print_for_tangent_method(double answer,double b){
        if(answer==b+1){
            System.out.println("f(a)*f(b)>=0");
        }
        else {
            System.out.println("Метод касательных:");
            System.out.println("x = "+answer);
        }
    }
    public static void print_difference(double first , double second){
        System.out.println("Разница между метотодом хорд и методом касательных = "+(first - second));
    }
    public static void print_for_Newtons_method(double[] answer){
        System.out.println("x = "+ answer[0]+" y =  "+answer[1]);
    }
}
