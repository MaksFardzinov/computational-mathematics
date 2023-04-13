package лаб1;

import java.util.Arrays;

public class Print {
    public static void answers(double[][] matrix){
        int counter=0;
        int second_counter=0;
        for (int i=0;i< matrix.length;i++){
            if((matrix[i][i]==0 | matrix[i][i]==-0)){
                counter++;
            }
            if(matrix[i][matrix.length]==0 | matrix[i][matrix.length]==0){
                second_counter++;
            }
        }
        if(counter==second_counter){
            System.out.println("Система имеет бессконечное количество решений");
        }
        else {
            System.out.println("Система не имеет решений");
        }
    }
    public static void triangle_matrix(double[][] matrix){
        System.out.println("Треуголяная матрица:\n"+ Arrays.deepToString(matrix).replace("], ", "]\n")+"\n");
    }
}