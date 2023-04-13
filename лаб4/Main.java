package лаб4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        List<Double> x_values = new ArrayList<>();
        List<Double> y_values = new ArrayList<>();
        for (double i=-5;i<=5;i=i+1){
            x_values.add(i);
            y_values.add(Math.sin(i));
        }
        //List<Double> x_values = input.x_values(); // -5, -3, 0, 3, 5
        //List<Double> y_values = input.y_values(); // 0.9589, -0.14112, 0, 0.14112, -0.9589
        double x = input.x();
        double[] coff = Cubic_splines_method.get_coff(x_values,y_values,x);
        Draw.graphics(coff,x,x_values);
        System.out.println(Math.sin(-5));
        System.out.println(Cubic_splines_method.get_y(coff,x,x_values));
    }
}
