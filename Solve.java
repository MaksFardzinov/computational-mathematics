package лаб5;

import java.util.ArrayList;

public class Solve {
    public static ArrayList<ArrayList<Double>> by_Euler(int f, double epsilon, double a,  double y_a, double b) {
        ArrayList<Double> x_value;
        ArrayList<Double> y_value;
        ArrayList<Double> C = new ArrayList<>();
        double h = 0.25;
        double L;
        double y;
        double y_true;
        double y_last = y_a;
        C.add(y_a - Functions.get_first_derivative(f,a,y_a));
        do {
            x_value = new ArrayList<>();
            y_value = new ArrayList<>();
            int k = (int) ((b - a) / h);
            y = y_a;
            for (int i = 0; i < k + 1; i++) {
                x_value.add(a + h * i);
                y_value.add(y);
                y_last = y;
                y = y + h * Functions.get(f, a + h * i, y);
            }
            y_true = (Functions.get_first_derivative(f, b - h, y_last)+C.get(0))
                    + h * Functions.get(f, b - h, y_last);
            L = Math.abs(y_true - y);
            h = h / 10;
            //if(h<0.00001){
               // break;
           // }
        } while (!(L <= epsilon));
        ArrayList<ArrayList<Double>> points = new ArrayList<>();
        points.add(x_value);
        points.add(y_value);
        points.add(C);
        points.add(C);
        return points;
    }
    }
