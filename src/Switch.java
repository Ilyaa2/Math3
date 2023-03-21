import Methods.*;
import util.Iterate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Switch {
    public static void main(String[] args) {
        interact();
    }

    private static final ArrayList<UnaryOperator<Double>>
            list_of_functions = new ArrayList<>() {{
        add(x -> (3 * x * x * x + 5 * x * x + 3 * x - 6));
        add(x -> (x * x));
        add(x -> (7 * x * x * x * x + 6 * x * x - 2));
        add(x -> (Math.exp(2) + x - 3));
        add(x -> ( x + 1 ));
    }};
    //если задумаешь делать доп задание, то реализуй класс функция, которая, будет иметь поля унари оператор, массив x'ов, которые сходятся, будут иметь значения в пределе,
    // а также массив x'ов, которые не будут сходится, там можно хранить Infinity. Можно сделать inner static class Dot(x,y).

    public static void interact() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Выберете функцию, введя ее номер");

            System.out.println("1: 3x^3 + 5x^2 + 3x -6");
            System.out.println("2: x^2");
            System.out.println("3: 7x^4 + 6x^2 - 2");
            System.out.println("4: e^2 + x - 3");
            System.out.println("5: x + 1");

            int selected_function = scanner.nextInt();
            if (!(selected_function >= 1 && selected_function <= 5)) throw new Exception();

            System.out.println("Введите пределы интегрирования от меньшего к большему");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            if (a > b) throw new Exception();

            System.out.println("Введите точность вычисления");
            double precision = scanner.nextDouble();

            System.out.println("Введите номер метода, которым нужно вычислить интеграл:");
            System.out.println("1: Метод прямоугольников");
            System.out.println("2: Метод трапеций");
            System.out.println("3: Метод Симпсона");

            int selected_method = scanner.nextInt();
            if (!(selected_method >= 1 && selected_method <= 3)) throw new Exception();

            Method method;

            if (selected_method == 1) {
                System.out.println("Введите номер модификации, которую хотите использовать:");
                System.out.println("1: Левые");
                System.out.println("2: Правые");
                System.out.println("3: Средние");
                int selected_mode = scanner.nextInt();
                if (!(selected_mode >= 1 && selected_mode <= 3)) throw new Exception();
                method = switch (selected_mode) {
                    case (1) -> new MethodRectangle(0, a, b, list_of_functions.get(selected_function - 1), TypeOfRectangle.LEFT);
                    case (2) -> new MethodRectangle(0, a, b, list_of_functions.get(selected_function - 1), TypeOfRectangle.RIGHT);
                    case (3) -> new MethodRectangle(0, a, b, list_of_functions.get(selected_function - 1), TypeOfRectangle.MIDDLE);
                    default -> throw new Exception();
                };
            } else if (selected_method == 2) {
                method = new MethodTrapezoid(0, a, b, list_of_functions.get(selected_function - 1));
            } else {
                method = new MethodOfSimpson(0, a, b, list_of_functions.get(selected_function - 1));
            }

            Iterate.iterate(method, precision);
        } catch (Exception e) {
            System.out.println("Введено не верное значение");
        }
    }


}
