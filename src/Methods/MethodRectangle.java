package Methods;

import java.util.function.UnaryOperator;

public class MethodRectangle extends Method {
    private final TypeOfRectangle mode;

    public MethodRectangle(int n, double a, double b, UnaryOperator<Double> function, TypeOfRectangle mode) {
        super(n, a, b, function);
        this.mode = mode;
    }

    @Override
    public double calculate() {
        return switch (mode) {
            case LEFT -> calculateForLeftMode(0d, (b - a) / n);
            case RIGHT -> calculateForRightMode(0d, (b - a) / n);
            case MIDDLE -> calculateForMiddleMode(0d, (b - a) / n);
        };
    }

    private double calculateForRightMode(double sum, double h) {
        for (int i = 1; i < n + 1; i++) {
            sum += function.apply(a + (i - 1) * h);
        }
        return h * sum;
    }

    private double calculateForLeftMode(double sum, double h) {
        for (int i = 1; i < n + 1; i++) {
            sum += function.apply(a + i * h);
        }
        return h * sum;
    }

    private double calculateForMiddleMode(double sum, double h) {
        for (int i = 1; i < n + 1; i++) {
            sum += function.apply((a + (i - 1) * h + a + i * h) / 2);
        }
        return h * sum;
    }
}
