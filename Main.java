package лаб5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int f = Integer.parseInt(bf.readLine());
        double e = Double.parseDouble(bf.readLine());
        double a = Double.parseDouble(bf.readLine());
        double y_a = Double.parseDouble(bf.readLine());
        double b = Double.parseDouble(bf.readLine());
        System.out.println(Functions.get_first_derivative(3,1,2));
        Draw.graphics(f,Solve.by_Euler(f, e, a, y_a, b));
    }
}
