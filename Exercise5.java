import java.util.*;

import java.util.stream.Stream;

public class Exercise5 {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> firstIter = first.iterator();
        Iterator<T> secondIter = second.iterator();
        Stream<T> resultStream = Stream.empty();
        while(firstIter.hasNext() && secondIter.hasNext()) {

            resultStream = Stream.concat(resultStream, Stream.of(firstIter.next(), secondIter.next()));
        }
        return resultStream;
    }
}
