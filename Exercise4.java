import java.util.stream.Stream;

public class Exercise4 {
    public static void main(String[] args) {

    }

    public Stream<Long> randomStream(long seed, long a, long c, double m){
        return Stream.iterate(seed, (x) -> x = ((a * x + c) % (long)m));

    }
}
