package com.лаб2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите '1' если хотите рещить нелинейное уровнение или введите '2' если хотите решить" +
                "систему нилинейных ураввнений");
        Scanner scanner = new Scanner(System.in);
        int method = scanner.nextInt();
        while(method!=1 & method!=2){
            System.out.println("Введите '1' если хотите рещить нелинейное уровнение или введите '2' если хотите"+
                            "решить систему нилинейных ураввнений");
            method = scanner.nextInt();
        }
        if(method == 1){
            System.out.println("Выберите уравнение из списка:\n1 x^3 - 0.2x + 0.5x + 1.5 = 0\n2 sin(x)=0\n3" +
                    " cos(x)=0\n4 cos(x) - 0.5 = 0\n5 (2 - x^3) : 2 = 0");
            int equation = scanner.nextInt();
            while(equation!=1 & equation!=2 & equation!=3 & equation!=4 & equation!=5){
                System.out.println("Введите 1 или 2 или 3 или 4 или 5 чтобы выбрать уравнение");
                equation = scanner.nextInt();
            }
            System.out.println("Введите значение левую границу интервала , правую границу интервала и точность");
            double a=0;
            double b=0;
            double e=0;
            try {
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                e = scanner.nextDouble();
            }
            catch (InputMismatchException exception){
                System.out.println("неправильный ввод данных, введите данные коректно\n справка:\n 1)не должно быть" +
                        " не каких символов кроме цифр\n 2)дробные числа записыватся через запятую");
                System.exit(0);
            }
            Print.print_for_method_hord(first_method.secant_method(a,b,e,equation),b);
            Print.print_for_tangent_method(second_method.tangent_method(a,b,e,equation),b);
            Print.print_difference(first_method.secant_method(a,b,e,equation),second_method.tangent_method(a,b,e,equation));
        }
        else{
            System.out.println("Выбирите систему уравнений из списка:\n1 x^2 - y - 1 = 0\n  e^x - x - y = 0\n" +
                    "2 x^2 + y^2 - 5 = 0\n  x^3 - y^3 - 1 =0\n3 x^2 + y^2 - 9 = 0\n  e^x + y - 6 = 0\n" +
                    "4 x^3 -3xy^2 - 2 = 0\n  x^2 + y^2 - 5 = 0");
            int equation = scanner.nextInt();
            while(equation!=1 & equation!=2 & equation!=3 & equation!=4 & equation!=5){
                System.out.println("Введите 1 или 2 или 3 или 4  чтобы выбрать уравнение");
                equation = scanner.nextInt();
            }
            System.out.println("Ввудите начальное приближение и точность");
            double x=0;
            double y=0;
            double e=0;
            try {
                x = scanner.nextDouble();
                y = scanner.nextDouble();
                e = scanner.nextDouble();
            }
            catch (InputMismatchException exception){
                System.out.println("неправильный ввод данных, введите данные коректно\n справка:\n 1)не должно быть" +
                        " не каких символов кроме цифр\n 2)дробные числа записыватся через запятую");
                System.exit(0);
            }
            Print.print_for_Newtons_method(third_method.Newtons_method(x,y,e,equation));
        }
    }
}

