package лаб3;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        int f=input.function();
        double a = input.a();
        Print.answer(Simpson_method.get_answer(f,a,input.b(a),input.e()));
        }
    }