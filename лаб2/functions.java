package com.лаб2;

public class functions {
    public static double function(double x, int f) {
        if (f == 1) {
            return Math.pow(x, 3) - 0.2 * x + 0.5 * x + 1.5;
        } else if (f == 2) {
            return Math.sin(x);
        } else if (f == 3) {
            return Math.cos(x);
        } else if (f == 4) {
            return Math.cos(x) - 0.5;
        } else {
            return (2 - Math.pow(x, 3)) / 2;
        }
    }

    public static double derivative_1(double x, int f) {
        if (f == 1) {
            return Math.pow(3 * x, 2) + 3 / 10;
        } else if (f == 2) {
            return Math.cos(x);
        } else if (f == 3) {
            return -Math.sin(x);
        } else if (f == 4) {
            return -Math.sin(x);
        } else {
            return Math.pow(6 * x, 5) - Math.pow(12 * x, 2);
        }
    }

    public static double derivative_2(double x, int f) {
        if (f == 1) {
            return 6 * x;
        } else if (f == 2) {
            return -Math.sin(x);
        } else if (f == 3) {
            return -Math.cos(x);
        } else if (f == 4) {
            return -Math.cos(x);
        } else {
            return -3 * x;
        }
    }

    public static double[] system_of_equations(double x, double y, int f) {
        double[] function = new double[2];
        if (f == 1) {
            function[0] = Math.pow(x, 2) - y - 1;
            function[1] = Math.exp(x) - x - y;
            return function;
        } else if (f == 2) {
            function[0] = Math.pow(x,2) + Math.pow(y,2)-5;
            function[1] = Math.pow(x, 3) + Math.pow(y, 3) - 1;
            return function;
        } else if (f == 3) {
            function[0] = Math.pow(x, 2) + Math.pow(y, 2) - 9;
            function[1] = Math.exp(x) + y - 6;
            return function;
        } else {
            function[0] = Math.pow(x, 3) + Math.pow(3 * x * y, 2) - 2;
            function[1] = Math.pow(x, 2) + Math.pow(y, 2) - 5;
            return function;
        }
    }

    public static double[][] derivative_for_system_of_equations(double x, double y, int f) {
        double[][] derivative = new double[2][2];
        if(f==1){
            derivative[0][0] = 2*x;
            derivative[0][1] = -1;
            derivative[1][0] = Math.exp(x) -1;
            derivative[1][1] = -1;
            return derivative;
        }
        else if(f==2){
            derivative[0][0] = 2*x;
            derivative[0][1] = 2*y;
            derivative[1][0] = Math.pow(3*x,2);
            derivative[1][1] = Math.pow(-3*y,2);
            return derivative;
        }
        else if(f==3){
            derivative[0][0] = 2*x;
            derivative[0][1] = 2*y;
            derivative[1][0] = Math.exp(x);
            derivative[1][1] = 1;
            return derivative;
        }
        else {
            derivative[0][0] = Math.pow(3*x,2);
            derivative[0][1] = -6*x*y;
            derivative[1][0] = 2*x;
            derivative[1][1] = 2*y;
            return derivative;
        }
    }
}
