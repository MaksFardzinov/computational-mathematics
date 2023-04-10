package лаб3;

import java.util.stream.IntStream;

public class Discontinuity {
    public static double fix(double x, int f,double e){
            return (Functions.get(x+e,f) + Functions.get(x-e,f))/2;
    }
}
