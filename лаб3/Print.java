package лаб3;

public class Print {
    public static void answer(double d){
        System.out.println("Получено значение интеграла: I = "+d);
    }
    public static void discontinuity(){
        System.out.println("На данном интервале есть разрыв первого рода он будет устронен по формуле:" +
                "f(x) = СРЗНАЧ(f(x-e),f(x+e))");
    }
}
