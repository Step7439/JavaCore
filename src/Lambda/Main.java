package Lambda;

import java.util.*;

public class Main {
    interface ICalculate {
        int calcujate(int a, int b);
    }
    public static void main(String[] args) {
        ICalculate sum = (a, b) -> a + b;
        ICalculate min = (a, b) -> a - b;
        ICalculate umn = (a, b) -> a * b;
        ICalculate dev = (a, b) -> a / b;

        System.out.println(sum.calcujate(4,5));
        System.out.println(dev.calcujate(1, 10));
        System.out.println(min.calcujate(5,4));
        System.out.println(umn.calcujate(5,6));
    }
}
