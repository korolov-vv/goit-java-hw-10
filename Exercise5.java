import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5 {
    public static void main(String[] args) {
        Stream<String> s1 = Arrays.stream(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K"});
        Stream<String> s2 = Arrays.stream(new String[]{"L", "M", "N", "O", "P", "Q", "R"});
        System.out.println(zip(s1, s2).collect(Collectors.joining(" ")));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        List<T> myList = Stream.concat(first, second)
                .collect(Collectors.toList());

        Collections.shuffle(myList);

        return myList.stream();
    }
}
