package Methods;

import java.util.function.UnaryOperator;

public class MethodTrapezoid extends Method {

    public MethodTrapezoid(int n, double a, double b, UnaryOperator<Double> function) {
        super(n, a, b, function);
    }

    @Override
    public double calculate() {
        double h = (b - a) / n;
        double sum = 0d;
        for (int i = 1; i < n; i++) {
            sum += function.apply(a + h * i);
        }
        return (2 * sum + function.apply(a) + function.apply(b)) * h / 2;
    }
}
