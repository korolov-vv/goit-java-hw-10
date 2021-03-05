import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise5 {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        List<T> myList = Stream.concat(first, second)
                .collect(Collectors.toList());

        Collections.shuffle(myList);

        return myList.stream();
    }
}
