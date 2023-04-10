package лаб3;

public class Simpson_method {
    public static double get_answer(int f,double a,double b,double e){
        int n =4;
        double first_x;
        double last_x;
        double answer =0;
        double h;
        double even_sum;
        double odd_sum;
        double a_plus_h=0;
        double r = e + 0.01;
        int count =0;
        double previous_answer = Functions.get_first_value(a,b,f,e);
        while (r>e){
            h = (b-a)/n;
            first_x = Functions.get(a,f);
            if(Double.isNaN(first_x) | Double.isInfinite(first_x)){
                first_x = Discontinuity.fix(a,f,e);
                count++;
            }
            a_plus_h +=h;
            last_x = Functions.get(b,f);
            if(Double.isInfinite(last_x) | Double.isNaN(last_x)){
                last_x = Discontinuity.fix(b,f,e);
                count++;
            }
            even_sum = 0;
            odd_sum = 0;
            for (int i =1;i<n;i++){
                if(i%2!=0){
                    double x = Functions.get(a_plus_h,f);
                    if(Double.isInfinite(x) | Double.isNaN(x)){
                        x = Discontinuity.fix(a_plus_h,f,e);
                        count++;
                    }
                    odd_sum+=x;
                }
                else {
                    double x = Functions.get(a_plus_h,f);
                    if(Double.isInfinite(x) | Double.isNaN(x)){
                        x = Discontinuity.fix(a_plus_h,f,e);
                        count++;
                    }
                    even_sum+=x;
                }
                a_plus_h+=h;
            }
            answer = h *(first_x+last_x+2*even_sum+4*odd_sum)/3;
            r = Math.abs(previous_answer-answer)/15;
            a_plus_h = a;
            previous_answer = answer;
            n=n*2;
       }
        Print.discontinuity();
        return answer;
    }
}
