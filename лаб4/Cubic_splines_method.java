package лаб4;

import лаб1.Gauss;

import java.util.List;

public class Cubic_splines_method {
    public static double function(double a,double b,double c, double d,double x,double x0){
        return (a+b*(x-x0)+c*Math.pow(x-x0,2)+d*Math.pow(x-x0,3));
    }
    public static double[] get_coff(List<Double> x_value, List<Double> y_value,double x) {
        double[][] matrix_for_func = new double[(x_value.size() - 1) * 4][((x_value.size() - 1) * 4) + 1];
        int count = 0;
        for (int i = 0; i < (x_value.size() - 1); i++) {
            matrix_for_func[count][0 + i * 4] = 1;
            matrix_for_func[count][matrix_for_func[0].length - 1] = y_value.get(i);
            matrix_for_func[count + 1][0 + i * 4] = 1;
            matrix_for_func[count + 1][1 + i * 4] = x_value.get(i + 1) - x_value.get(i);
            matrix_for_func[count + 1][2 + i * 4] = Math.pow(x_value.get(i + 1) - x_value.get(i), 2);
            matrix_for_func[count + 1][3 + i * 4] = Math.pow(x_value.get(i + 1) - x_value.get(i), 3);
            matrix_for_func[count + 1][matrix_for_func[0].length - 1] = y_value.get(i + 1);
            count = count + 2;
        }
        for (int i = 0; i < (x_value.size() - 2); i++) {
            matrix_for_func[count][1 + i * 4] = 1;
            matrix_for_func[count][2 + i * 4] = 2 * (x_value.get(i + 1) - x_value.get(i));
            matrix_for_func[count][3 + i * 4] = 3 * Math.pow(x_value.get(i + 1) - x_value.get(i), 2);
            matrix_for_func[count][5 + i * 4] = -1;
            matrix_for_func[count + 1][2 + i * 4] = 2;
            matrix_for_func[count + 1][3 + i * 4] = 6 * (x_value.get(i + 1) - x_value.get(i));
            matrix_for_func[count + 1][6 + i * 4] = -2;
            count = count + 2;
        }
        matrix_for_func[count][2] = 2;
        matrix_for_func[count][matrix_for_func[0].length - 1] = 0;
        matrix_for_func[count + 1][(x_value.size() - 1) * 4 - 2] = 2;
        matrix_for_func[count + 1][(x_value.size() - 1) * 4 - 1] = 6 * (x_value.get((x_value.size()) - 1) - x_value.get((x_value.size()) - 2));
        Gauss.make_triangle(matrix_for_func);
        return Gauss.get_answer(matrix_for_func);
    }
    public static double get_y(double[] coff,double x,List<Double> x_value){
        double result = 0;
        for (int i=0;i<x_value.size()-1;i++){
            if(x <= x_value.get(i+1)){
                result = function(coff[i*4],coff[1+i*4],coff[2+i*4],coff[3+i*4],x,x_value.get(i));
                break;
            }
        }
        return result;
    }
}
