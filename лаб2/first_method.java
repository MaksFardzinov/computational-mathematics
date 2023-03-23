package com.лаб2;

public class first_method {
    public static double secant_method (double a, double b, double e,int f) {
        if(functions.function(a,f)*functions.function(b,f)>0){
            return b+1;
        }
        else {
            double next;
            double old;
            if(functions.function(a,f)*functions.derivative_2(a,f)>0){
                do {
                    old = a;
                    next = a - functions.function(a, f)  * (b-a) / (functions.function(b, f) - functions.function(a, f));
                    a = next;
                }
                while (Math.abs(a - old) > e);
            }
            else {
                do {
                    old = b;
                    next = b - functions.function(b, f)  * (b-a) / (functions.function(b, f) - functions.function(a, f));
                    b = next;
                }
                while (Math.abs(b - old) > e);
            }
            return next;
        }
    }
}
