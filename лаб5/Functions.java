package лаб5;

public class Functions {
    public static double get(int f,double x,double y){
        if (f==1){
            return Math.sin(x);
        }
        else if(f==2){
           return  (x * y)/2;
        }
        else if (f==3){
            return (y*x) - (Math.pow(x,2)/y);
        }
        else if (f==4){
            return x+y;
        }
        else {
            return 0.0;
        }
    }
    public static double get_first_derivative(int f,double x,double y){
        if (f==1){
            return -Math.cos(x);
        }
        else if(f==2){
            return  y * Math.pow(x,2) / 4;
        }
        else if (f==3){
            return (y * x) - (Math.pow(x,2) / y);
        }
        else if (f==4){
            return (Math.pow(x,2) / 2) + (y*x);
        }
        else {
            return 0.0;
        }
    }
}
