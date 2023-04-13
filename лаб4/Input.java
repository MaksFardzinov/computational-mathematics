package лаб4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

public class Input {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public List<Double> x_values() throws IOException {
        List<Double> x_values = Stream.of(bf.readLine().split(" "))
                .map(Double::parseDouble).collect(toList());
        return x_values;
    }
    public  List<Double> y_values() throws IOException {
        List<Double> x_values = Stream.of(bf.readLine().split(" "))
                .map(Double::parseDouble).collect(toList());
        return x_values;
    }
    public  double x() throws IOException {
        double x = Double.parseDouble(bf.readLine());
        return x;
    }
    public  void bufferdReader_close() throws IOException {
        bf.close();
    }
}
