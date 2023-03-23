package com.лаб2;

public class second_method {
    public static double tangent_method(double a, double b, double e, int f){
        if(functions.function(a,f)*functions.function(b,f)>0){
            return b+1;
        }
        else {
            double old;
            double next;
            if(functions.function(a,f)*functions.derivative_2(a,f)>0){
                do {
                    old = a;
                    next = a - (functions.function(a,f)/functions.derivative_1(a,f));
                    a = next;
                }
                while (Math.abs(a-old) > e);
            }
            else{
                do {
                    old = b;
                    next = b - (functions.function(b,f)/functions.derivative_1(b,f));
                    b = next;
                }
                while (Math.abs(b-old) > e);
                }
            return next;
        }
    }
}
