package лаб3;

public class Functions {
    public static double get(double x,int f){
        if(f==1){
            return 1 / (x + 5);
        }
        else if(f==2){
            return Math.sin(x)/x;
        }
        else {
            return (Math.pow(x,2)+Math.pow(x,3))/(x-1);
        }
    }
    public static double get_first_value(double a,double b,int f,double e){
        int n =2;
        double first_x;
        double last_x;
        double answer;
        double h =(b-a)/n;
        first_x = Functions.get(a,f);
        if(Double.isNaN(first_x) | Double.isInfinite(first_x)){
            first_x = Discontinuity.fix(a,f,e);
        }
        last_x = Functions.get(b,f);
        if(Double.isInfinite(last_x) | Double.isNaN(last_x)){
            last_x = Discontinuity.fix(b,f,e);
        }
        double x =Functions.get(a+h,f);
        if(Double.isInfinite(x) | Double.isNaN(x)){
            x = Discontinuity.fix(a+h,f,e);
        }
        answer = h/3*(first_x+last_x + 4*x);
        System.out.println(answer);
        return answer;
    }
}
