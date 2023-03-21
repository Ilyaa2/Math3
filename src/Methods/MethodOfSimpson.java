package Methods;

import java.util.function.UnaryOperator;

public class MethodOfSimpson extends Method {

    public MethodOfSimpson(int n, double a, double b, UnaryOperator<Double> function) {
        super(n, a, b, function);
    }

    @Override
    public double calculate() {
        double h = (b - a) / n;
        double sum = 0d;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                sum += 2 * function.apply(a + h * i);
            } else {
                sum += 4 * function.apply(a + h * i);
            }
        }
        return (sum + function.apply(a) + function.apply(b)) * h / 3;
    }
}
