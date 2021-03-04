import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> names = List.of("Adrian", "David", "Luis", "Zinedine", "Ivan", "Petro", "Adolf", "Iosif");
        String[] numbers = new String[]{"1, 2, 0", "4, 5"};

        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        long limit = 10;

        System.out.println("Exercise 1 result:");
        System.out.println(new Exercise1().filter(names));
        System.out.println();
        System.out.println("Exercise 2 result:");
        System.out.println(new Exercise2().changed(names).toString());
        System.out.println();
        System.out.println("Exercise 3 result:");
        new Exercise3().sortNumbers(numbers);

        System.out.println();
        System.out.println("Exercise 4 result:");
        new Exercise4().randomStream(0, a, c, m)
                .limit(limit)
                .forEach((l) -> System.out.print(l.toString().concat(", ")));
    }
}
