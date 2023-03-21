package com.лаб1;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int size=0;
        int index=0;
        ArrayList<Double> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 'консоль' для ввода данных через консоль, 'файл' для считывания данных из файла" +
                " или 'рандом' для генерации случайной матрицы");
        String method = scanner.next();
        while ((!method.equals("консоль")) & (!method.equals("файл")) &(!method.equals("рандом"))) {
            System.out.println("Введите данные коректно");
            method = scanner.next();
        }
        if (method.equals("консоль")) {
            System.out.println("Введите размер матрицы");
            size = scanner.nextInt();
            while (size < 2) {
                System.out.println("размер матрицы должен быть больше 1");
                size = scanner.nextInt();
            }
            System.out.println("Введите  матрицу");
            try {
                for (int i = 0; i <size; i++) {
                    for (int j = 0; j < size+1; j++) {
                        arrayList.add(scanner.nextDouble());
                    }
                }
                index=1;
            }
            catch (InputMismatchException e){
                System.out.println("неправильный ввод данных, введите данные коректно\n справка:\n 1)не должно быть" +
                        " не каких символов кроме цифр\n 2)дробные числа записыватся через запятую");
                System.exit(0);
            }

        }
        else if (method.equals("файл")){
            try {
                BufferedReader buffer = new BufferedReader( new FileReader("files/file1.txt"));
                while (buffer.ready()){
                    arrayList2.add(buffer.readLine());
                }
                size = arrayList2.size();
                for (int i = 0; i <size; i++) {
                    for (int j = 0; j <size+1; j++) {
                    }
                }
                index=2;
            }
            catch (FileNotFoundException e) {
                System.out.println("Файл не найден!");
                System.exit(0);
            }
        }
        else{
            System.out.println("Введите размер матрицы");
            size = scanner.nextInt();
            for (int i = 0; i <size; i++) {
                for (int j = 0; j <size+1; j++) {
                    arrayList.add( (Math.random()*((20.00-1)+1.00))+1.00);
                }
            }
            index=1;
        }
        //long start = System.currentTimeMillis();
        double[][] matrix = new double[size][size+1];
        if(index==1){
            int count =0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = arrayList.get(count);
                    count++;
                }
            }
        }
        if(index==2){
            for (int i = 0; i <size; i++) {
                for (int j = 0; j <size+1; j++) {
                    String[] line = arrayList2.get(i).split(" ");
                    try{
                        matrix[i][j] = Double.parseDouble(line[j]);
                    }
                    catch (NumberFormatException e){
                            System.out.println("неправильный ввод данных, введите данные коректно\n справка:\n 1)не должно быть" +
                                    " не каких символов кроме цифр\n 2)дробные числа записыватся через точку");
                            System.exit(0);
                        }
                }
            }
        }
        double[][] triangle_matrix = Gauss.make_triangle(matrix);
            Print.triangle_matrix(triangle_matrix);
            System.out.println("определитель матрицы равен:"+Gauss.determinate(triangle_matrix));
            System.out.println();
                if (Gauss.determinate(triangle_matrix)!=0) {
                    System.out.println("Корни Системы уравнений\n");
                    double[] answers=Gauss.get_answer(matrix);
                    for (int i=0;i<answers.length;i++){
                        System.out.println("x"+(i+1)+" = "+answers[i]);
                    }
                    double[] neviaski=Gauss.find_neviaski(triangle_matrix,answers);
                    System.out.println("Ветор невязки\n");
                    for (int i=0;i<neviaski.length;i++){
                        System.out.println(neviaski[i]);
                    }
                }
                else {
                    Print.answers(triangle_matrix);
                }
        //long finish = System.currentTimeMillis();
        //System.out.println("Время работы метода - "+(finish-start)+" миллисекунд");
    }
}
