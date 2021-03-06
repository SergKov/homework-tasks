package homework5.task32;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by koval on 18.12.2016.
 */
public class Integral {

    public static final double EPS = .05;

    private final double a;
    private final double b;
    private final Function<Double, Double> function;

    public Integral(double a, double b, Function<Double, Double> function) {
        this.a = a;
        this.b = b;
        this.function = function;
    }

    public Double getValue(final Double point) {
        return function.apply(point);
    }

    public Double calculate(final Double a, final Double b) {

        double sum = (getValue(a) + getValue(b)) * (b - a) / 2;

        if (b - a < EPS) {
            sum += calculate(a, b / 2);
            sum += calculate(b / 2, b);
        }

        return sum;
    }

    public class Calculator implements Runnable {

        private final int count;

        public Calculator(int count) {
            this.count = count;
        }

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        final Integral integral = new Integral(0D, Math.PI, Math::sin);
        System.out.println(integral.calculate(0D, Math.PI));
    }
}
