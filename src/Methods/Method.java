package Methods;

import java.util.function.UnaryOperator;

public abstract class Method {
    //метод должен понимать какой у него n или h, поставлять это сверху
    protected int n;
    protected final double a;
    protected final double b;
    protected final UnaryOperator<Double> function;

    public Method(int n, double a, double b, UnaryOperator<Double> function){
        this.a = a;
        this.b = b;
        this.n = n;
        this.function = function;
    }

    public abstract double calculate();

    public void setN(int n){
        this.n = n;
    }

    public int getN(){
        return n;
    }
}
