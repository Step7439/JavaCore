package StreamAPI;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Stream<Integer> stream = intList.stream();
        stream
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}

//class StreamMain {
//    public static void main(String[] args) {
//        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
//        List<Integer> intList1 = new ArrayList<>();
//        Collections.sort(intList);
//        for ( int x : intList) {
//            if (x > 0 && x % 2 == 0) {
//                System.out.println(x);
//            }
//            }
//        }
//
//    }

