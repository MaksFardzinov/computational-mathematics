package com.лаб1;


public class Gauss {
    public static double determinate(double[][] matrix){
        return matrix[matrix.length-1][matrix.length-1];
    }
    public static double[][] make_triangle(double[][] matrix) {
        double dioganal = 1;
        int size = matrix.length;
        for (int i = 0; i < size; i++){
            dioganal = dioganal * matrix[i][i];
    }
        if (dioganal!=0){
            transformation(matrix);
        }
        else{
            int number;
            double[] matrix_for_clone = new double[size+1];
            for (int j=0;j<size+1;j++){
                for( int i=j+1;i<size;i++){
                        if (matrix[j][j] == 0) {
                            if (matrix[i][j] != 0) {
                                number = i;
                                for (int l = 0; l < matrix[0].length; l++) {
                                    matrix_for_clone[l] = matrix[number][l];
                                    matrix[number][l] = matrix[j][l];
                                    matrix[j][l] = matrix_for_clone[l];
                                }
                                break;
                            }
                        }
                        else {
                            break;
                        }
                }
            }
            for (int i = 0; i < size; i++){
                dioganal = dioganal * matrix[i][i];
            }
                transformation(matrix);
        }
        return matrix;
    }
    public static double[][] transformation(double[][] matrix){
        int size = matrix.length;
        for (int p=0;p<size-1;p++){
            double first_element=0;
            double del = matrix[p][p];
            for (int o =0;o<size+1;o++){
                if(matrix[p][p]!=0) {
                    matrix[p][o] = matrix[p][o] / del;
                    first_element = matrix[p][p];
                }
            }
            for (int i=p+1;i<size;i++) {
                if (matrix[i][p] != 0) {
                    double dell = matrix[i][p] /first_element;
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = matrix[i][j] - matrix[p][j] * dell;
                    }
                }
            }
        }
        return matrix;
    }
    public static double[] get_answer(double[][] matrix){
        double x;
        double[] answers = new double[matrix.length];
        for(int i= matrix.length-1;i>-1;i--){
            int amount=i;
            if (i==matrix.length-1){
                answers[matrix.length-1]=matrix[i][matrix.length]/matrix[i][matrix.length-1];
            }
            else {
                x = matrix[i][matrix.length];
                while (amount < matrix.length - 1) {
                    x = x - matrix[i][amount + 1] * answers[amount + 1];
                    amount++;
                }
                answers[i] = x;
            }
        }
       return answers;
    }
    public static double[] find_neviaski(double[][] matrix,double[] answers){
        double[] neviaski = new double[matrix.length];
        for (int i=0;i< matrix.length;i++){
            double counter =0;
            double answer = matrix[i][matrix.length];
            for (int j=0;j<matrix.length;j++){
                counter=counter+matrix[i][j]*answers[j];
            }
            neviaski[i]=answer-counter;
        }
        return neviaski;
    }
}
