import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> names = List.of("Adrian", "David", "Luis", "Zinedine", "Ivan", "Petro", "Adolf", "Iosif");
        String[] numbers = new String[]{"1, 2, 0", "4, 5"};

        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        long limit = 10;
        Stream<String> s1 = Arrays.stream(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"});
        Stream<String> s2 = Arrays.stream(new String[]{"L", "M", "N", "O", "P", "Q", "R"});


        System.out.println("Exercise 1 result:");
        System.out.println(new Exercise1().filter(names));

        System.out.println();
        System.out.println("Exercise 2 result:");
        System.out.println(new Exercise2().changed(names));

        System.out.println();
        System.out.println("Exercise 3 result:");
        System.out.println(new Exercise3().sortNumbers(numbers));

        System.out.println();
        System.out.println("Exercise 4 result:");
        new Exercise4().randomStream(0, a, c, m)
                .limit(limit)
                .forEach((l) -> System.out.print(l.toString().concat(", ")));

        System.out.println("\n");
        System.out.println("Exercise 5 result:");
        System.out.println(Exercise5.zip(s1, s2).collect(Collectors.joining(" ")));
    }
}
