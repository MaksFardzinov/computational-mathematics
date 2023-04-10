package лаб3;

import java.util.Scanner;

public class Input {
    public  Integer function(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 или 2 или 3 чтобы выбрать уравнение\n1) 1 / (x + 5)\n2) sin(x) / x\n" +
                "3) (x^2 + x^3) / (x - 1)");
        int f = scanner.nextInt();
        while (f!=1 & f!=2 & f !=3){
            System.out.println("Вы ввели не правильное значение!\nВведите 1 или 2 или 3 чтобы выбрать уравнение");
            f = scanner.nextInt();
        }
        return f;
    }
    public double a(){
        System.out.println("Введите нижний предел  интеграла интегрирования a");
        Scanner sc = new Scanner(System.in);
        try {
            return  sc.nextInt();
        }
        catch (Exception e){
            System.out.println("Число a должно быть целым. Введите нижний предел  интеграла интегрирования a");
            return  a();
        }
    }
    public  double b(double a){
        System.out.println("Введите верхний предел  интеграла интегрирования b");
        Scanner scanner = new Scanner(System.in);
        try {
            double b = scanner.nextInt();
            while (a>b){
                System.out.println("Значение b должно быть больше чем a");
                b = scanner.nextInt();
            }
            return b;
        }
        catch (Exception e){
            System.out.println("Число b должно быть целым. Введите нижний предел  интеграла интегрирования b");
            return b(a);
        }
    }
    public  double e (){
        System.out.println("Введите точность");
        Scanner scanner = new Scanner(System.in);
        try {
            return  scanner.nextDouble();
        }
        catch (Exception e){
            System.out.println("Спрвка:\n1) Дробные числа записываются через запятую\n2) Вы не должны использовать" +
                    "никаких символов кроме цифр и запятой");
            return e();
        }
    }
}
