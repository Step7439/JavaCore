package Lambda;

import java.util.function.*;

public class Main1 {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(2, 2);
        int b = calc.minus.apply(3,1);
        int c = calc.devide.apply(a, b);

        calc.println.accept(a);
        calc.println.accept(b);
        calc.println.accept(c);
    }

}
class Calculator{
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y)-> x > 0 && y > 0 ? x / y : 0;
    // Делить на ноль лезя
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
