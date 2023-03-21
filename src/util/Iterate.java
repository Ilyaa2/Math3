package util;

import Methods.Method;

public class Iterate {
    public static void iterate(Method method, double precision){
        int n = 4;
        int k = 0;
        method.setN(n);
        double previous;
        double current = method.calculate();
        do{
            previous = current;
            n = n*2;
            method.setN(n);
            current = method.calculate();
            k++;
            if (k>100 || Double.isInfinite(current)) {
                System.out.println("Введена слишком большая точность для этого метода");
                System.exit(-1);
            }
        } while(Math.abs(current - previous) >= precision);
        System.out.println("Ответ: " + current);
        System.out.println("Число разбиения интервала: " + (n/2));
    }
}
