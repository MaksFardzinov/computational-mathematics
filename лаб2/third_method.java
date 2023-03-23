package com.лаб2;

public class third_method {
    public static double[][] inverse_matrix(double[][] matrix){
        double det = matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        double m00 = matrix[0][0];
        double m01 = matrix[0][1];
        double m10 = matrix[1][0];
        double m11 = matrix[1][1];
        matrix[0][0] = 1/det*m11;
        matrix[0][1] = 1/det*-m01;
        matrix[1][0] = 1/det*-m10;
        matrix[1][1] = 1/det*m00;
        return matrix;
    }

    public static double[] Newtons_method(double x,double y,double e,int f){
        double[] error = new double[2];
        double[] answer = new double[2];
        do {
            error[0]=0;
            error[1]=0;
            double[] matrix_function = functions.system_of_equations(x, y, f);
            double[][] matrix = functions.derivative_for_system_of_equations(x, y, f);
            inverse_matrix(matrix);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    error[i] = error[i]+matrix[i][j] * -matrix_function[j];
                }
            }
            answer[0] = x;
            answer[1] = y;
            x = x + error[0];
            y = y + error[1];
        }
        while (Math.max(Math.abs(error[0]),Math.abs(error[1])) > e);
        return answer;
    }
}
